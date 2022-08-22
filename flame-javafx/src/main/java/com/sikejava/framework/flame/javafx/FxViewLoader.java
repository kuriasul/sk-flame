package com.sikejava.framework.flame.javafx;

import javafx.scene.Parent;

/**
 * JavaFx视图装载器
 *
 * @author skjv2014@163.com
 * @since 2022-08-20 11:34:08
 */
public interface FxViewLoader {

    /**
     * 装载视图
     *
     * @param fxmlPath fxml路径
     * @return FxViewVO<C> 视图
     * @author skjv2014@163.com
     * @since 2022-08-21 18:43:00
     */
    <C> FxViewVO<C> load(String fxmlPath);

    /**
     * 装载视图
     *
     * @param fxmlPath fxml路径
     * @param cssPath css路径
     * @return FxViewVO<C> 视图
     * @author skjv2014@163.com
     * @since 2022-08-21 18:43:00
     */
    <C> FxViewVO<C> load(String fxmlPath, String cssPath);
}
