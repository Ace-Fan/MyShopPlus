package com.wufan.myshop.plus.business.dto.params;

import lombok.Data;

import java.io.Serializable;

/**
 * @author songw
 */
@Data
public class IconParam implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像地址
     */
    private String path;

}
