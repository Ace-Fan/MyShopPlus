package com.wufan.myshop.plus.business.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录信息
 * @author songw
 * @date 2020/5/4
 */
@Data
public class LoginInfo implements Serializable {

    private String name;
    private String avatar;
    private String nickName;
}
