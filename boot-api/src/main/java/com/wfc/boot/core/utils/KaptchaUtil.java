package com.wfc.boot.core.utils;

import com.wfc.boot.core.properties.SystemProperties;

/**
 * 验证码工具类
 */
public class KaptchaUtil {

    /**
     * 获取验证码开关
     */
    public static Boolean getKaptchaOnOff() {
        return SpringContextHolder.getBean(SystemProperties.class).getKaptchaOpen();
    }
}