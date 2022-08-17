package com.sikejava.framework.flame.common.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * 基础对象
 *
 * @author skjv2014@163.com
 * @since 2022-08-18 00:45:20
 */
public class BaseObject implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
