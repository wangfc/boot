package com.wfc.boot.mapper;

import com.wfc.boot.entity.Menu;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@Repository
public interface MenuMapper extends Mapper<Menu> {

    List<String> getResUrlsByRoleId(Integer roleId);
}