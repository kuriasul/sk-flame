package com.sikejava.framework.flame.javafx;

import com.sikejava.framework.flame.common.exception.ExecutionException;

/**
 * JavaFx异常
 *
 * @author skjv2014@163.com
 * @since 2022-08-19 08:00:36
 */
public class JavaFxException extends ExecutionException {

    public JavaFxException(String message) {
        super(message);
    }

    public JavaFxException(Throwable cause) {
        super(cause);
    }

    public JavaFxException(String message, Throwable cause) {
        super(message, cause);
    }
}
