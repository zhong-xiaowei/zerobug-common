package cn.com.zerobug.common.context;

import static cn.com.zerobug.common.utils.ThreadLocalUtil.*;

/**
 * @author zhongxiaowei
 * @date 2022/3/31
 */
public class GlobalContextHolder {

    public static final String USER_ID  = "USER_ID";
    public static final String TENANT   = "TENANT";
    public static final String TRACE_ID = "TRACE_ID";

    public static void setUserId(Long userId) {
        set(USER_ID, userId);
    }

    public static void setTenant(Long tenantId) {
        set(TENANT, tenantId);
    }

    public static void setTraceId(String traceId) {
        set(TRACE_ID, traceId);
    }

    public static Long getUserId() {
        return get(USER_ID);
    }

    public static Long getTenant() {
        return get(TENANT);
    }

    public static String getTraceId() {
        return get(TRACE_ID);
    }

    public static void removeUserId() {
        remove(USER_ID);
    }

    public static void removeTenant() {
        remove(TENANT);
    }

    public static void removeTraceId() {
        remove(TRACE_ID);
    }

    public static void clear() {
        remove();
    }

}
