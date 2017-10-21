package com.wfc.boot.service;

import com.wfc.boot.entity.User;
import com.wfc.boot.support.BaseService;

import java.util.List;

public interface UserService extends BaseService<User>{
    User find(User qm);

    List<User> getUserList(User qm) throws Exception;
}
