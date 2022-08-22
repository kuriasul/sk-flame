package com.sikejava.framework.flame.common.exception;

/**
 * 执行异常
 *
 * @author skjv2014@163.com
 * @since 2022-08-18 00:11:39
 */
public abstract class ExecutionException extends RuntimeException {

    protected ExecutionException(String message) {
        super(message);
    }

    protected ExecutionException(Throwable cause) {
        super(cause);
    }

    protected ExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
