package cn.com.zerobug.common.context;

import cn.hutool.core.convert.Convert;
import org.slf4j.MDC;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.AsyncWebRequestInterceptor;
import org.springframework.web.context.request.WebRequest;

import static cn.com.zerobug.common.utils.ServletUtil.getHeader;
import static cn.com.zerobug.common.utils.ServletUtil.getRequest;

/**
 * @author zhongxiaowei
 * @date 2022/4/3
 */
public class GlobalParameterRequestInterceptor implements AsyncWebRequestInterceptor {

    @Override
    public void afterConcurrentHandlingStarted(WebRequest request) {

    }

    @Override
    public void preHandle(WebRequest request) throws Exception {

        Long   tenantId = Convert.toLong(getHeader(getRequest(request), GlobalParameterConstant.HEADER_FOR_TENANT_ID));
        String userId   = Convert.toStr(GlobalContextHolder.getUserId());

        GlobalContextHolder.setTenant(tenantId);
        MDC.put(GlobalParameterConstant.MDC_USER_ID, userId);
    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {
    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {
        GlobalContextHolder.clear();
    }

}
