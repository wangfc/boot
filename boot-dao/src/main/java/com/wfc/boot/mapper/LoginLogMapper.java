package com.wfc.boot.mapper;

import com.wfc.boot.entity.LoginLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface LoginLogMapper extends Mapper<LoginLog> {

}