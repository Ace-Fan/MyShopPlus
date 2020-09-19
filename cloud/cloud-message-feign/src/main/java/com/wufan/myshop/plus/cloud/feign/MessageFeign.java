package com.wufan.myshop.plus.cloud.feign;

import com.wufan.myshop.plus.cloud.feign.fallback.MessageFeignFallback;
import com.wufan.myshop.plus.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@FeignClient(value = "cloud-message",path = "message",configuration = FeignRequestConfiguration.class,fallback = MessageFeignFallback.class)
public interface MessageFeign {

  /*  @PostMapping(value = "admin/login/log")
    public String sendAdminLoginLog(@RequestBody UmsAdminLoginLogDTO dto);*/
}
