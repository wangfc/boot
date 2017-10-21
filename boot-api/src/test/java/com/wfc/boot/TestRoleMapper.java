package com.wfc.boot;



import com.wfc.boot.base.BaseTest;
import com.wfc.boot.entity.Role;
import com.wfc.boot.mapper.RoleMapper;
import org.junit.Test;

import javax.annotation.Resource;

public class TestRoleMapper extends BaseTest{

    @Resource
    private RoleMapper roleMapper;

    @Test
    public void test(){
        Role role = roleMapper.selectByPrimaryKey(1);
        logger.info(role +"");
    }
}
