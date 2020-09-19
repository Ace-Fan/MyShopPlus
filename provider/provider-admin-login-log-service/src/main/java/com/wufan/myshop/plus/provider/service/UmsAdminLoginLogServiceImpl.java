package com.wufan.myshop.plus.provider.service;

import com.wufan.myshop.plus.provider.api.UmsAdminLoginLogService;
import com.wufan.myshop.plus.provider.domain.UmsAdminLoginLog;
import com.wufan.myshop.plus.provider.mapper.UmsAdminLoginLogMapper;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@Service(version = "1.0.0")
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService{

    @Resource
    private UmsAdminLoginLogMapper umsAdminLoginLogMapper;

    @Override
    public int insert(UmsAdminLoginLog umsAdminLoginLog) {
        return umsAdminLoginLogMapper.insert(umsAdminLoginLog);
    }
}
