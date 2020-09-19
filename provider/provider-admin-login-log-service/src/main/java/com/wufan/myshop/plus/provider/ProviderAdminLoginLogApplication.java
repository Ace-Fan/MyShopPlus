package com.wufan.myshop.plus.provider;

import com.wufan.myshop.plus.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@SpringBootApplication(scanBasePackageClasses = {ProviderAdminLoginLogApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "com.wufan.myshop.plus.provider.mapper")
public class ProviderAdminLoginLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminLoginLogApplication.class,args);
    }
}
