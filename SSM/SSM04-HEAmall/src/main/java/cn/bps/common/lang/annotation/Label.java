package cn.bps.common.lang.annotation;

import java.lang.annotation.*;

/**
 * 单纯用来标记,未编写解析接口
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Label {
    String value();
}
