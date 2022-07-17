package cn.com.zerobug.common.context;

/**
 * @author zhongxiaowei
 * @date 2022/4/3
 */
public interface GlobalParameterConstant {

    /**
     * 租户 Id 头
     */
    String HEADER_FOR_TENANT_ID = "X-TENANT-ID";

    /**
     * MDC 用户id 标记
     */
    String MDC_USER_ID = "userId";

}
