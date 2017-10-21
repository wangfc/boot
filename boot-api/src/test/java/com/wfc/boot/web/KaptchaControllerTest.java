package com.wfc.boot.web;

import com.wfc.boot.base.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

public class KaptchaControllerTest extends BaseTest {

    @Resource
    KaptchaController kaptchaController;

    @Test
    public void testIndex() throws Exception{

        this.get("/kaptcha");
    }

}
