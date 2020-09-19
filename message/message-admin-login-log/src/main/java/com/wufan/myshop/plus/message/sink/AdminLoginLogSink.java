package com.wufan.myshop.plus.message.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
public interface AdminLoginLogSink {

    @Input("admin-login-log-topic")
    SubscribableChannel adminLoginLog();
}
