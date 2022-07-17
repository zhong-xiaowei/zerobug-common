package cn.com.zerobug.common.enums.convert;

/**
 * 标记为可转换枚举，在前端传参时，会自动转换为对应的枚举值
 *
 * @author zhongxiaowei
 * @contact zhongxiaowei.nice@gmail.com
 * @date 2022/6/2
 */
public interface ConvertibleEnum<T> {

    /**
     * 获取枚举代码
     *
     * @return 枚举代码
     */
    T getCode();

}
