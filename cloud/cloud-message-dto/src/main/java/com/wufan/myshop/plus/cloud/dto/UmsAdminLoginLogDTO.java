package com.wufan.myshop.plus.cloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author songw
 * @date 2020/5/16
 */
@Data
public class UmsAdminLoginLogDTO implements Serializable {
    private Long id;
    private Long adminId;
    private Date createTime;
    private String ip;
    private String address;
    private String userAgent;
    private static final long serialVersionUID = 736469259501368483L;
}
