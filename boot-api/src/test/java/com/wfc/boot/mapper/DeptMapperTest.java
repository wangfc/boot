package com.wfc.boot.mapper;

import com.wfc.boot.base.BaseTest;
import com.wfc.boot.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangfc
 * @date 2017-09-25 19:36
 */
@Slf4j
public class DeptMapperTest extends BaseTest {
    @Resource
    DeptMapper deptMapper;

    @Test
    public void test(){

        List<Dept> depts = deptMapper.selectAll();
        log.debug("====" + depts);

    }

}