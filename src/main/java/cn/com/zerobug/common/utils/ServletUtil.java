package cn.com.zerobug.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author zhongxiaowei
 * @date 2022/4/3
 */
public class ServletUtil {

    public ServletUtil() {
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static HttpServletRequest getRequest(WebRequest webRequest) {
        return ((ServletWebRequest) Objects.requireNonNull(webRequest)).getRequest();
    }

    public static HttpServletRequest getRequest(ServletRequest request) {
        // ServletRequest to HttpServletRequest
        if (request instanceof HttpServletRequest) {
            return (HttpServletRequest) request;
        }
        throw new ClassCastException("request is not a HttpServletRequest");
    }

    public static String getParameter(String name) {
        return getParameter(getRequest(), name, "");
    }

    public static String getParameter(String name, String defaultValue) {
        return getParameter(getRequest(), name, defaultValue);
    }

    public static String getParameter(HttpServletRequest request, String name, String defaultValue) {
        String value = request.getParameter(name);
        if (StrUtil.isEmpty(value)) {
            return defaultValue;
        }
        return URLUtil.decode(value);
    }

    public static String getHeader(String name) {
        return getRequest().getHeader(name);
    }

    public static String getHeader(HttpServletRequest request, String name) {
        String value = request.getHeader(name);
        if (StrUtil.isEmpty(value)) {
            return "";
        }
        return URLUtil.decode(value);
    }

    @SuppressWarnings("AlibabaUndefineMagicConstant")
    public static String getRemoteAddress(HttpServletRequest request) {
        String xFor = request.getHeader("X-Forwarded-For");
        if (!isUnknown(xFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = xFor.indexOf(",");
            if (index != -1) {
                return xFor.substring(0, index);
            }
            return xFor;
        }
        if (!isUnknown(xFor = request.getHeader("X-Real-IP"))) {
            return xFor;
        }
        if (!isUnknown(xFor = request.getHeader("Proxy-Client-IP"))) {
            return xFor;
        }
        if (!isUnknown(xFor = request.getHeader("WL-Proxy-Client-IP"))) {
            return xFor;
        }
        if (!isUnknown(xFor = request.getHeader("HTTP_CLIENT_IP"))) {
            return xFor;
        }
        if (!isUnknown(xFor = request.getHeader("HTTP_X_FORWARDED_FOR"))) {
            return xFor;
        }
        if (!isUnknown(xFor = request.getRemoteAddr())) {
            return xFor;
        }
        return xFor;
    }

    public static boolean isUnknown(String checkString) {
        return StrUtil.isBlank(checkString) || "unknown".equalsIgnoreCase(checkString);
    }

}
