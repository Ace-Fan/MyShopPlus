package com.wufan.myshop.plus.provider.service;

import com.wufan.myshop.plus.provider.api.EchoService;
import org.apache.dubbo.config.annotation.Service;

/**
 *
 * @author songw
 * @date 2020/4/12
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String string) {
        return "Echo Hello Dubbo " + string;
    }
}
