package cn.waggag.yatou.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: 系统配置类
 * @author: waggag
 */
@Component
@Data
@ConfigurationProperties(prefix = "yatou")
public class YaTouConfig {
    /**
     * 项目名称
     */
    private String name;
    /**
     * 版本
     */
    private String version;
    /**
     * 版权年份
     */
    private String copyrightYear;
}
