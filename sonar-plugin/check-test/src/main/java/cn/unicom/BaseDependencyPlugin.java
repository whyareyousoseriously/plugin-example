package cn.unicom;

import org.sonar.api.Plugin;

/**
 * 基础依赖扫描，扫描项目是否使用了星舟基础依赖
 * @author chenzhen
 */
public class BaseDependencyPlugin implements Plugin {
    public void define(Context context) {
        // implementations of extension points
        context.addExtensions(FooLanguage.class, ExampleProperties.class);

    }
}
