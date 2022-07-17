package cn.com.zerobug.common.config;

import cn.com.zerobug.common.context.GlobalParameterRequestInterceptor;
import cn.com.zerobug.common.enums.convert.NuclearConverterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhongxiaowei
 * @date 2022/4/3
 */
public class GlobalMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(new GlobalParameterRequestInterceptor())
                .addPathPatterns("/**").order(-99);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new NuclearConverterFactory());
    }
}
