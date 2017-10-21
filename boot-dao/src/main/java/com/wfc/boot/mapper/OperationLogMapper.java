package com.wfc.boot.mapper;

import com.wfc.boot.entity.OperationLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OperationLogMapper extends Mapper<OperationLog> {

}