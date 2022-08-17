package com.sikejava.framework.flame.common.exception;

/**
 * 系统异常
 *
 * @author skjv2014@163.com
 * @since 2022-08-18 00:32:13
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
}
