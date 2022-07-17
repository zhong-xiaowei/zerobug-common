package cn.com.zerobug.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zhongxiaowei
 * @date 2022/2/25
 */
@Slf4j
public class ExceptionUtil {

    /**
     * 异常捕获打印日志
     *
     * @param errorConsumer 异常消费者
     * @param errorMsg      异常消息
     */
    public static void recordError(Consumer<String> errorConsumer, String errorMsg) {
        try {
            errorConsumer.accept("");
        } catch (Exception e) {
            log.error(errorMsg, e);
        }
    }

    /**
     * 异常捕获封装 并打印日志 可返回结果
     *
     * @param supplier 结果获取
     * @param errorMsg 异常消息
     */
    public static <T, R> R recordError(Supplier<T> supplier, String errorMsg) {
        try {
            return (R) supplier.get();
        } catch (Exception e) {
            log.error(errorMsg, e);
            return null;
        }
    }

}
