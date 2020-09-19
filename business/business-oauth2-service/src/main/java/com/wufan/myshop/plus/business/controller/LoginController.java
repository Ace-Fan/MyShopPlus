package com.wufan.myshop.plus.business.controller;

import com.google.common.collect.Maps;
import com.wufan.myshop.plus.business.BusinessException;
import com.wufan.myshop.plus.business.BusinessStatus;
import com.wufan.myshop.plus.business.dto.LoginInfo;
import com.wufan.myshop.plus.business.dto.LoginParam;
import com.wufan.myshop.plus.business.feign.ProfileFeign;
import com.wufan.myshop.plus.commons.dto.ResponseResult;
import com.wufan.myshop.plus.commons.utils.MapperUtils;
import com.wufan.myshop.plus.commons.utils.OkHttpClientUtil;
import com.wufan.myshop.plus.provider.domain.UmsAdmin;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 *
 * 登录管理
 * @author songw
 * @date 2020/5/1
 */
@RestController
public class LoginController {

    private static final String URL_OAUTH_TOKEN = "http://localhost:9001/oauth/token";

    @Value("${business.oauth2.grant_type}")
    private String oauth2GrantType;

    @Value("${business.oauth2.client_id}")
    private String oauth2ClientId;

    @Value("${business.oauth2.client_secret}")
    private String oauth2ClientSecret;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    @Resource
    public TokenStore tokenStore;

    @Resource
    private ProfileFeign profileFeign;

//    @Resource
//    private MessageFeign messageFeign;
//
//    @Reference(version = "1.0.0")
//    private UmsAdminService umsAdminService;
//
//    @Reference(version = "1.0.0")
//    private MessageService messageService;

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, Object>> login(@RequestBody LoginParam loginParam, HttpServletRequest request) throws Exception {
        // 封装返回的结果集
        Map<String, Object> result = Maps.newHashMap();

        // 验证密码是否正确
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            throw new BusinessException(BusinessStatus.ADMIN_PASSWORD);
        }

        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);

        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseResult<Map<String, Object>>(ResponseResult.CodeStatus.OK, "登录成功", result);
    }


    /**
     * 获取用户信息
     * @return
     */
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(value = "/user/info")
    public ResponseResult<LoginInfo> info() throws Exception {
        //获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        //获取个人信息
        String jsonString = profileFeign.info(authentication.getName());
        UmsAdmin umsAdmin = MapperUtils.json2pojoByTree(jsonString, "data", UmsAdmin.class);

        // 如果触发熔断则返回熔断结果
        if (umsAdmin == null) {
            return MapperUtils.json2pojo(jsonString, ResponseResult.class);
        }

        //封装并返回结果
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(umsAdmin.getUsername());
        loginInfo.setAvatar(umsAdmin.getIcon());
        loginInfo.setNickName(umsAdmin.getNickName());

        return new ResponseResult<LoginInfo>(ResponseResult.CodeStatus.OK, "获取登录信息", loginInfo);
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping(value = "/user/logout")
    public ResponseResult<Void> logout(HttpServletRequest request)  {
        // 获取 token
        String token = request.getParameter("access_token");
        // 删除 token 以注销
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token);
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new ResponseResult<Void>(ResponseResult.CodeStatus.OK, "用户已注销");
    }

    /*private boolean sendAdminLoginLog(String username,HttpServletRequest request)  {
        UmsAdmin umsAdmin = umsAdminService.get(username);

        String ip = UserAgentUtils.getIpAddr(request);
        String address = UserAgentUtils.getIpInfo(ip).getCity();
        String userAgent = UserAgentUtils.getBrowser(request).getName();


        UmsAdminLoginLogDTO dto = new UmsAdminLoginLogDTO();
        dto.setAdminId(umsAdmin.getId());
        dto.setCreateTime(new Date());
        dto.setIp(ip);
        dto.setAddress(address);
        dto.setUserAgent(userAgent);


        return messageService.sendAdminLoginLog(dto);
    }*/
}
