package com.wufan.myshop.plus.business;

/**
 *
 * @author songw
 * @date 2020/5/17
 */
public class BusinessException extends RuntimeException{

    private static final long serialVersionUID = -805034687844043219L;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException() {

    }

    public BusinessException(BusinessStatus status) {
        super(status.getMessage());
        this.code = status.getCode();
    }
}
