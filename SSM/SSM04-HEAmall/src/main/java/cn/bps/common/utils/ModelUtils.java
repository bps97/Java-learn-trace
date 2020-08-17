package cn.bps.common.utils;

import org.springframework.beans.BeanUtils;

/**
 * @author feizns
 * @since 2020/6/1
 */
public class ModelUtils {

    public static <T> T copyTo(Object original, Class<T> targetType) {
        T instance = newInstance(targetType);
        BeanUtils.copyProperties(original, instance);
        return instance;
    }

    public static <T> T newInstance(Class<T> targetType) {
        try {
            return targetType.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
