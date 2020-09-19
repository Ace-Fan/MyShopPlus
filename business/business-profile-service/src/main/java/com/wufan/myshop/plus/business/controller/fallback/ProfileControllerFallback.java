package com.wufan.myshop.plus.business.controller.fallback;

import com.wufan.myshop.plus.business.dto.UmsAdminDTO;
import com.wufan.myshop.plus.business.feign.fallback.ProfileFeignFallback;
import com.wufan.myshop.plus.commons.dto.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author songw
 * @date 2020/5/10
 */
public class ProfileControllerFallback {
    private static final Logger logger = LoggerFactory.getLogger(ProfileControllerFallback.class);

    /**
     * 熔断方法
     *
     * @param username {@code String} 用户名
     * @return {@link ResponseResult<UmsAdminDTO>}
     */
    public static ResponseResult<UmsAdminDTO> infoFallback(String username, Throwable ex) {
        logger.warn("Invoke infoFallback: " + ex.getClass().getTypeName());
        ex.printStackTrace();
        return new ResponseResult<UmsAdminDTO>(ResponseResult.CodeStatus.BREAKING, ProfileFeignFallback.BREAKING_MESSAGE);
    }

}
