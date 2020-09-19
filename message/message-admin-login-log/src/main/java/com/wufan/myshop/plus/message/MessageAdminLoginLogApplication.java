package com.wufan.myshop.plus.message;

import com.wufan.myshop.plus.message.sink.AdminLoginLogSink;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@SpringBootApplication
@EnableBinding(AdminLoginLogSink.class)
public class MessageAdminLoginLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageAdminLoginLogApplication.class,args);
    }
}
