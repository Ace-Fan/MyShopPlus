package com.wufan.myshop.plus.cloud.api;

import com.wufan.myshop.plus.cloud.dto.UmsAdminLoginLogDTO;

/**
 *
 * @author songw
 * @date 2020/5/17
 */
public interface MessageService {

    boolean sendAdminLoginLog(UmsAdminLoginLogDTO dto);
}
