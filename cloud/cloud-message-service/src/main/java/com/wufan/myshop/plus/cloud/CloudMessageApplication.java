package com.wufan.myshop.plus.cloud;

import com.wufan.myshop.plus.cloud.message.MessageSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(MessageSource.class)
public class CloudMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudMessageApplication.class,args);
    }
}
