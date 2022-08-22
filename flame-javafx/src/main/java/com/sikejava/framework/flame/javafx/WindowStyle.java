package com.sikejava.framework.flame.javafx;

import com.sikejava.framework.flame.common.model.BaseObject;

import javafx.scene.paint.Color;
import javafx.stage.StageStyle;

/**
 * 窗口样式
 *
 * @author skjv2014@163.com
 * @since 2022-08-22 00:29:50
 */
public class WindowStyle extends BaseObject {
    /**
     * 标题
     */
    private String title;
    /**
     * 舞台格式
     */
    private StageStyle stageStyle;
    /**
     * 场景填充颜色
     */
    private Color sceneFillColor;

    public static WindowStyle newDefault(String title) {
        WindowStyle windowStyle = new WindowStyle();
        windowStyle.title = title;
        windowStyle.stageStyle = StageStyle.DECORATED;
        windowStyle.sceneFillColor = Color.WHITE;
        return windowStyle;
    }

    public static WindowStyle newWithoutBar(String title) {
        WindowStyle windowStyle = new WindowStyle();
        windowStyle.title = title;
        windowStyle.stageStyle = StageStyle.TRANSPARENT;
        windowStyle.sceneFillColor = Color.TRANSPARENT;
        return windowStyle;
    }

    public static WindowStyle newCustom(String title, StageStyle stageStyle, Color sceneFillColor) {
        WindowStyle windowStyle = new WindowStyle();
        windowStyle.title = title;
        windowStyle.stageStyle = stageStyle;
        windowStyle.sceneFillColor = sceneFillColor;
        return windowStyle;
    }

    public String getTitle() {
        return title;
    }

    public StageStyle getStageStyle() {
        return stageStyle;
    }

    public Color getSceneFillColor() {
        return sceneFillColor;
    }
}
