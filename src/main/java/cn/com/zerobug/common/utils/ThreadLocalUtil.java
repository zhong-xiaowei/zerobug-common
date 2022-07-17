package cn.com.zerobug.common.utils;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhongxiaowei
 * @date 2022/3/31
 */
public class ThreadLocalUtil {

    /**
     * 全局本地线程
     * 可以在线程中设置和获取数据
     * 支持多线程操作
     *
     * @see {@link TransmittableThreadLocal}
     */
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = TransmittableThreadLocal.withInitial(() ->
            new ConcurrentHashMap<>(6));

    public ThreadLocalUtil() {

    }

    /**
     * 获取全局变量
     */
    public static Map<String, Object> getLocalMap() {
        return THREAD_LOCAL.get();
    }

    /**
     * 设置全局变量
     *
     * @param keyValueMap
     */
    public static void setLocalMap(Map<String, Object> keyValueMap) {
        Map<String, Object> map = THREAD_LOCAL.get();
        map.putAll(keyValueMap);
    }

    /**
     * 获取全局变量 根据 key 获取
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T get(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return get(key, null);
    }

    /**
     * 获取全局变量 根据 key 获取，可设置默认值
     *
     * @param key
     * @param defaultValue 默认值
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T get(String key, T defaultValue) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return (T) Optional.ofNullable(map.get(key)).orElse(defaultValue);
    }

    /**
     * 设置全局变量
     *
     * @param key
     * @param value
     */
    public static void set(String key, Object value) {
        if (key == null || value == null) {
            return;
        }
        Map<String, Object> map = THREAD_LOCAL.get();
        map.put(key, value);
    }

    /**
     * 移除全局变量
     */
    public static void remove() {
        THREAD_LOCAL.remove();
    }

    /**
     * 移除全局变量
     *
     * @param key
     */
    @SuppressWarnings("unchecked")
    public static <T> T remove(String key) {
        Map<String, Object> map = THREAD_LOCAL.get();
        return (T) map.remove(key);
    }
}
