package com.sikejava.framework.flame.javafx;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * JavaFx视图service
 *
 * @author skjv2014@163.com
 * @since 2022-08-19 07:43:22
 */
public class JavaFxViewService implements ApplicationContextAware {
    /**
     * spring应用上下文
     */
    private ApplicationContext applicationContext;

    public Parent getParent(String fxmlPath, String cssPath) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setLocation();
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
