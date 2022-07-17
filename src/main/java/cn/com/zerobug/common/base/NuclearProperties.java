package cn.com.zerobug.common.base;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhongxiaowei
 * @date 2022/4/2
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = NuclearProperties.PREFIX)
public class NuclearProperties {

    public static final String PREFIX                  = "zerobug";
    public static final String APPLICATION_INFO_PREFIX = PREFIX + "application-info";

    /**
     * 全局配置
     */
    private boolean         enableGlobalConfig = true;
    /**
     * 应用程序info
     */
    private ApplicationInfo applicationInfo;

    @Data
    @NoArgsConstructor
    public static class ApplicationInfo {

        /**
         * 应用程序名称
         */
        private String name;
        /**
         * 应用程序版本
         */
        private String version;
        /**
         * 应用程序描述
         */
        private String description;
        /**
         * 应用程序springboot版本
         */
        private String springbootVersion;

    }


}


