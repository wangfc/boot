package com.wfc.boot.mapper;

import com.wfc.boot.entity.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface DeptMapper extends Mapper<Dept> {

}