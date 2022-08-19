package com.sikejava.framework.flame.javafx;

import javafx.stage.Stage;

/**
 * 窗口视图
 *
 * @author skjv2014@163.com
 * @since 2022-08-18 07:44:32
 */
public interface WindowView extends JavaFxView {

    /**
     * 获取stage
     *
     * @return Stage stage
     * @author skjv2014@163.com
     * @since 2022-08-19 02:09:49
     */
    Stage getStage();
}
