package com.wfc.boot.core.shiro.factory;


import com.wfc.boot.core.shiro.ShiroUser;
import com.wfc.boot.model.User;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

import java.util.List;

/**
 * shiro接口
 *
 * @author wangfc
 * @date 2017-09-24 15:22
 */
public interface ShiroFactory {

    /**
     * 根据账号获取登录用户
     *
     * @param account 账号
     */
    User user(String account);

    /**
     * 根据系统用户获取Shiro的用户
     *
     * @param user 系统用户
     */
    ShiroUser shiroUser(User user);

    /**
     * 获取权限列表通过角色id
     *
     * @param roleId 角色id
     */
    List<String> findPermissionsByRoleId(Integer roleId);

    /**
     * 根据角色id获取角色名称
     *
     * @param roleId 角色id
     */
    String findRoleNameByRoleId(Integer roleId);

    /**
     * 获取shiro的认证信息
     */
    SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName);
}