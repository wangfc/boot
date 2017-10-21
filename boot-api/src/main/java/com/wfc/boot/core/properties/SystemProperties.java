package com.wfc.boot.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统参数
 *
 * @author wangfc
 * @date 2017-09-24 10:14
 */
@Component
@ConfigurationProperties(prefix = SystemProperties.SYSTEM_PREFFIX)
@Data
public class SystemProperties {
    public static final String SYSTEM_PREFFIX = "system";

    private Boolean kaptchaOpen = false;

    private Boolean swaggerOpen = false;

    private String fileUploadPath;

    private Boolean haveCreatePath = false;

    private Boolean springSessionOpen = false;

    private Integer sessionInvalidateTime = 30 * 60;  //session 失效时间（默认为30分钟 单位：秒）

    private Integer sessionValidationInterval = 15 * 60;  //session 验证失效时间（默认为15分钟 单位：秒）

}