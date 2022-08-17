package com.sikejava.framework.flame.common.exception;

/**
 * 业务异常
 *
 * @author skjv2014@163.com
 * @since 2022-08-18 00:26:20
 */
public class BusinessException extends RuntimeException {
    /**
     * 错误代码
     */
    private String code;

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
