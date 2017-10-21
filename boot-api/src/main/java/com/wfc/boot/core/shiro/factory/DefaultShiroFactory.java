package com.wfc.boot.core.shiro.factory;

import com.wfc.boot.core.shiro.ShiroUser;
import com.wfc.boot.core.utils.Convert;
import com.wfc.boot.core.utils.SpringContextHolder;
import com.wfc.boot.entity.Dept;
import com.wfc.boot.entity.Menu;
import com.wfc.boot.entity.Role;
import com.wfc.boot.mapper.DeptMapper;
import com.wfc.boot.mapper.MenuMapper;
import com.wfc.boot.mapper.RoleMapper;
import com.wfc.boot.mapper.UserMapper;
import com.wfc.boot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.functors.ConstantFactory;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfc
 * @date 2017-09-24 17:14
 */
@Component
@Transactional(readOnly = true)
@DependsOn("springContextHolder")
@Slf4j
public class DefaultShiroFactory implements ShiroFactory {

    @Resource
    UserMapper userMapper;

    @Resource
    DeptMapper deptMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    MenuMapper menuMapper;

    public static ShiroFactory shiroFactory(){
       return SpringContextHolder.getBean(ShiroFactory.class);
    }

    @Override
    public User user(String account) {
        com.wfc.boot.entity.User u = new com.wfc.boot.entity.User();
        u.setAccount(account);
        com.wfc.boot.entity.User select = userMapper.selectOne(u);
        if (select == null ){
            throw new CredentialsException();
        }
        User user = new User() ;

        BeanUtils.copyProperties(select,user);

        return user;
    }

    @Override
    public ShiroUser shiroUser(User user) {
        ShiroUser shiroUser = new ShiroUser();
        shiroUser.setAccount(user.getAccount());
        shiroUser.setDeptId(user.getDeptid());

        Dept dept = deptMapper.selectByPrimaryKey(user.getDeptid());
        shiroUser.setDeptName(dept.getFullname());

        shiroUser.setId(user.getId());
        shiroUser.setName(user.getName());

        String roleid = user.getRoleid();
        Integer[] roleArray = Convert.toIntArray(user.getRoleid());// 角色集合
        List<Integer> roleList = new ArrayList<Integer>();
        List<String> roleNameList = new ArrayList<String>();

        for (int roleId : roleArray) {
            roleList.add(roleId);
            roleNameList.add(roleMapper.selectByPrimaryKey(roleId).getName());
        }
        shiroUser.setRoleList(roleList);
        shiroUser.setRoleNames(roleNameList);

        return shiroUser;
    }

    @Override
    public List<String> findPermissionsByRoleId(Integer roleId) {
        return menuMapper.getResUrlsByRoleId(roleId);
    }

    @Override
    public String findRoleNameByRoleId(Integer roleId) {

        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null ){
            return "--";
        }
        return role.getTips();
    }

    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getSalt();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }
}