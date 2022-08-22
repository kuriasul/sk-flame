package com.sikejava.framework.flame.javafx;

import java.net.URL;
import java.util.Objects;

/**
 * 资源工具类
 *
 * @author skjv2014@163.com
 * @since 2022-08-19 07:54:34
 */
public final class ResourceUtils {

    /**
     * 获取fxml文件url
     *
     * @param fxmlPath fxml文件路径
     * @return String fxml文件url
     * @author skjv2014@163.com
     * @since 2022-08-19 08:04:30
     */
    public static URL getFxmlUrl(String fxmlPath) {
        return getFileUrl("/template/" + fxmlPath + ".fxml");
    }

    /**
     * 获取css文件外部形式
     *
     * @param cssPath css文件路径
     * @return String css文件外部形式
     * @author skjv2014@163.com
     * @since 2022-08-19 08:04:30
     */
    public static String getCssExternalForm(String cssPath) {
        return getFileExternalForm("/css/" + cssPath + ".css");
    }

    /**
     * 获取图片文件外部形式
     *
     * @param imagePath 图片文件路径
     * @return String 图片文件外部形式
     * @author skjv2014@163.com
     * @since 2022-08-19 08:04:30
     */
    public static String getImageExternalForm(String imagePath) {
        return getFileExternalForm("/image/" + imagePath + ".jpg");
    }

    /**
     * 获取文件外部形式
     *
     * @param filePath 文件路径
     * @return String 文件外部形式
     * @author skjv2014@163.com
     * @since 2022-08-22 00:59:11
     */
    public static String getFileExternalForm(String filePath) {
        return getFileUrl(filePath).toExternalForm();
    }

    /**
     * 获取文件url
     *
     * @param filePath 文件路径
     * @return URL 文件url
     * @author skjv2014@163.com
     * @since 2022-08-22 00:59:11
     */
    public static URL getFileUrl(String filePath) {
        URL fileUrl = ResourceUtils.class.getResource(filePath);
        if (Objects.isNull(fileUrl)) {
            throw new JavaFxException(filePath + "路径对应的文件资源不存在");
        }
        return fileUrl;
    }

    private ResourceUtils() {}
}
