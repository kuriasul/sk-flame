package com.sikejava.framework.flame.javafx;

import com.sikejava.framework.flame.common.model.BaseObject;

import javafx.scene.Parent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * JavaFx视图VO
 *
 * @author skjv2014@163.com
 * @since 2022-08-22 23:13:12
 */
@Getter
@RequiredArgsConstructor
public class FxViewVO<C> extends BaseObject {
    private final Parent root;
    private final C controller;
}
