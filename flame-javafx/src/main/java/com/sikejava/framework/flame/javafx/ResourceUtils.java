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
     * 方法描述
     *
     * @param 参数说明
     * @return 返回说明
     * @author skjv2014@163.com
     * @since 2022-08-19 08:04:30
     */
    public static String getFxml(String fxmlPath) {
        URL resource = ResourceUtils.class.getResource(JavaFxConstant.FXML_PATH_PREFIX + fxmlPath);
        if (Objects.isNull(resource)) {
            throw new JavaFxException(fxmlPath + "路径对应的fxml资源不存在");
        }
        return resource.toExternalForm();
    }

    private ResourceUtils() {}
}
