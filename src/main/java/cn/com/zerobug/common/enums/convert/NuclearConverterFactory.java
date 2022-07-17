package cn.com.zerobug.common.enums.convert;

import cn.hutool.core.util.StrUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author zhongxiaowei
 * @contact zhongxiaowei.nice@gmail.com
 * @date 2022/6/2
 */
public class NuclearConverterFactory implements ConverterFactory<String, ConvertibleEnum> {

    @Override
    public <T extends ConvertibleEnum> Converter<String, T> getConverter(Class<T> targetType) {
        T[] enums = targetType.getEnumConstants();
        return source -> {
            for (T t : enums) {
                if (compare(t.getCode(), source)) {
                    return t;
                }
            }
            return null;
        };
    }

    private boolean compare(Object o1, Object o2) {
        if (o1.getClass().isAssignableFrom(o2.getClass())) {
            return o1.equals(o2);
        }
        return StrUtil.equals(o1.toString(), o2.toString());
    }
}
