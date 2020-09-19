package com.wufan.myshop.plus.cloud.feign.fallback;

import com.wufan.myshop.plus.cloud.feign.MessageFeign;
import org.springframework.stereotype.Component;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@Component
public class MessageFeignFallback implements MessageFeign {

    private static final String BREAKING_MESSAGE="请求失败，请检查网络";
    /*@Override
    public String sendAdminLoginLog(UmsAdminLoginLogDTO dto) {
        return null;
    }*/
}
