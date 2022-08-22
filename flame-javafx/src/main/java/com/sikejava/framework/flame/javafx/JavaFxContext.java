package com.sikejava.framework.flame.javafx;

import org.springframework.context.ApplicationContext;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * javafx上下文
 *
 * @author skjv2014@163.com
 * @since 2022-08-10 23:51:27
 */
public enum JavaFxContext {
    /**
     * 单实例
     */
    INSTANCE;

    /**
     * 应用class
     */
    private static Class<?> appClass;

    /**
     * 应用参数
     */
    private static String[] appArgs;

    /**
     * spring上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * fx视图装载器
     */
    private static FxViewLoader fxViewLoader;

    public static Class<?> getAppClass() {
        return appClass;
    }

    public static void setAppClass(Class<?> appClass) {
        JavaFxContext.appClass = appClass;
    }

    public static String[] getAppArgs() {
        return appArgs;
    }

    public static void setAppArgs(String[] appArgs) {
        JavaFxContext.appArgs = appArgs;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        JavaFxContext.applicationContext = applicationContext;
        JavaFxContext.fxViewLoader = new FxViewSpringLoader(applicationContext);
    }

    /**
     * 装载视图
     *
     * @param fxmlPath fxml路径
     * @return Parent 视图
     * @author skjv2014@163.com
     * @since 2022-08-21 18:43:00
     */
    public static <C> FxViewVO<C> load(String fxmlPath) {
        return fxViewLoader.load(fxmlPath);
    }

    /**
     * 装载视图
     *
     * @param fxmlPath fxml路径
     * @param cssPath css路径
     * @return Parent 视图
     * @author skjv2014@163.com
     * @since 2022-08-21 18:43:00
     */
    public static <C> FxViewVO<C> load(String fxmlPath, String cssPath) {
        return fxViewLoader.load(fxmlPath, cssPath);
    }

    /**
     * 展示窗口
     *
     * @param root 根视图
     * @param windowStyle 窗口样式
     * @author skjv2014@163.com
     * @since 2022-08-22 00:45:28
     */
    public static void showWindow(Parent root, WindowStyle windowStyle) {
        Stage window = new Stage();

        window.setTitle(windowStyle.getTitle());
        window.initStyle(windowStyle.getStageStyle());
        window.setScene(new Scene(root, windowStyle.getSceneFillColor()));

        window.show();
    }
}
