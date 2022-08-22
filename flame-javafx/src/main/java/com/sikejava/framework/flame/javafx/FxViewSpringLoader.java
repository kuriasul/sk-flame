package com.sikejava.framework.flame.javafx;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * JavaFx视图spring装载器
 *
 * @author skjv2014@163.com
 * @since 2022-08-21 18:44:08
 */
public class FxViewSpringLoader implements FxViewLoader {

    /**
     * spring上下文
     */
    private ApplicationContext applicationContext;

    public FxViewSpringLoader(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public <C> FxViewVO<C> load(String fxmlPath) {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtils.getFxmlUrl(fxmlPath));
        fxmlLoader.setControllerFactory(this.applicationContext::getBean);

        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new JavaFxException("加载视图异常", e);
        }

        C controller = fxmlLoader.getController();

        return new FxViewVO<>(root, controller);
    }

    @Override
    public <C> FxViewVO<C> load(String fxmlPath, String cssPath) {
        FxViewVO<C> fxViewVO = load(fxmlPath);

        if (StringUtils.hasText(cssPath)) {
            fxViewVO.getRoot().getStylesheets().add(ResourceUtils.getCssExternalForm(cssPath));
        }

        return fxViewVO;
    }
}
