package com.wufan.myshop.plus.business;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author songw
 */
@SpringBootApplication(scanBasePackageClasses = {BusinessOAuth2Application.class},scanBasePackages = "com.wufan.myshop.plus.cloud.feign")
@EnableDiscoveryClient
@EnableFeignClients
public class BusinessOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(BusinessOAuth2Application.class, args);
    }

}
