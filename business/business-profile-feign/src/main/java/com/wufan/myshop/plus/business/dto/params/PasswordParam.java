package com.wufan.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author songw
 * @date 2020/5/6
 */
@Data
public class PasswordParam implements Serializable {

    private String username;
    private String oldPassword;
    private String newPassword;

}
