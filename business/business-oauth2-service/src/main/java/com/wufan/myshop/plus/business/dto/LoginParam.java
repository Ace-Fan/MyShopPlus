package com.wufan.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录参数
 * @author songw
 * @date 2020/5/1
 */
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;

}
