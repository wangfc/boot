package com.wfc.boot.base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public abstract  class BaseTest {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected MockMvc mockMvc;

    @Resource
    protected WebApplicationContext webApplicationContext;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    public void get(String url) throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.ALL);

        ResultActions resultActions  = this.mockMvc.perform(requestBuilder);
        MvcResult mvcResult = resultActions.andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        assertTrue("http状态正确", status == 200);
        assertFalse("http状态错误", status != 200);

        System.out.println("返回结果："+status);
        System.out.println(content);
    }

    public void post(String url) throws Exception{

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.ALL);

        ResultActions resultActions  = this.mockMvc.perform(requestBuilder);
        MvcResult mvcResult = resultActions.andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        assertTrue("http状态正确", status == 200);
        assertFalse("http状态错误", status != 200);

        System.out.println("返回结果："+status);
        System.out.println(content);
    }

}
