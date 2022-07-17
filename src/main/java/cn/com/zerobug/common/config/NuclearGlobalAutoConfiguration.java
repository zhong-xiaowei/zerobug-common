package cn.com.zerobug.common.config;

import cn.com.zerobug.common.base.NuclearProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基础全局配置
 *
 * @author zhongxiaowei
 * @date 2022/4/3
 */
@Configuration
@EnableConfigurationProperties(NuclearProperties.class)
public class NuclearGlobalAutoConfiguration {

    @ConditionalOnProperty(prefix = "nuclear", value = {"enableGlobalConfig"}, havingValue = "true")
    protected class GlobalConfig {

        @Bean
        public GlobalMvcConfigure globalMvcConfigure() {
            return new GlobalMvcConfigure();
        }

    }

}
