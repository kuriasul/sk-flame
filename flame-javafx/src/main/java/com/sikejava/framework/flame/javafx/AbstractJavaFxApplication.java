package com.sikejava.framework.flame.javafx;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象的JavaFx应用
 *
 * @author skjv2014@163.com
 * @since 2022-08-21 18:06:28
 */
@Slf4j
public abstract class AbstractJavaFxApplication extends Application {

    /**
     * 启动窗口展示
     */
    private final CompletableFuture<Runnable> bootWindowShow = new CompletableFuture<>();

    /**
     * 启动应用
     *
     * @param appClass 应用类
     * @param appArgs 应用参数
     * @author skjv2014@163.com
     * @since 2022-08-21 18:21:50
     */
    public static void launch(Class<? extends Application> appClass, String[] appArgs) {
        JavaFxContext.setAppClass(appClass);
        JavaFxContext.setAppArgs(appArgs);

        Application.launch(appClass, appArgs);
    }

    @Override
    public void init() throws Exception {
        CompletableFuture.supplyAsync(() -> {
            long startTime = System.currentTimeMillis();
            ConfigurableApplicationContext applicationContext = SpringApplication.run(JavaFxContext.getAppClass(), JavaFxContext.getAppArgs());
            long sleepTime = 2000 - (System.currentTimeMillis() - startTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    log.error("系统异常. 异常详情: ", e);
                    Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "系统异常");
                        alert.showAndWait().ifPresent(response -> Platform.exit());
                    });
                }
            }
            return applicationContext;
        }).whenComplete((applicationContext, throwable) -> {
            if (Objects.nonNull(throwable)) {
                log.error("加载springboot异常. 异常详情: ", throwable);
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "加载springboot失败");
                    alert.showAndWait().ifPresent(response -> Platform.exit());
                });
            } else {
                JavaFxContext.setApplicationContext(applicationContext);
            }
        }).thenAcceptBothAsync(bootWindowShow, (applicationContext, closeBootWindow) -> {
            Platform.runLater(closeBootWindow);
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage bootWindow = getBootWindow();
        bootWindow.show();

        bootWindowShow.complete(() -> {
            bootWindow.close();
            startIndex(primaryStage);
        });
    }

    /**
     * 获取启动窗口
     *
     * @return Stage 启动窗口
     * @author skjv2014@163.com
     * @since 2022-08-21 18:14:35
     */
    protected abstract Stage getBootWindow();

    /**
     * 启动首页
     *
     * @param primaryStage 首页
     * @author skjv2014@163.com
     * @since 2022-08-21 18:31:25
     */
    protected abstract void startIndex(Stage primaryStage);
}
