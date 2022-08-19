package com.sikejava.framework.flame.javafx;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * 默认启动视图
 *
 * @author skjv2014@163.com
 * @since 2022-08-19 02:14:13
 */
public class DefaultBootView implements WindowView {

    /**
     * 根
     */
    private Parent root;

    /**
     * stage
     */
    private Stage stage;

    public DefaultBootView() {
        // root
        ImageView imageView = new ImageView();
        imageView.setImage(new Image(getClass().getResource("/image/splashScreen.jpg").toExternalForm()));

        HBox hBox = new HBox();
        hBox.getChildren().add(imageView);

        root = hBox;

        // stage
        
    }

    @Override
    public Parent getRoot() {
        return null;
    }

    @Override
    public Stage getStage() {
        return null;
    }
}
