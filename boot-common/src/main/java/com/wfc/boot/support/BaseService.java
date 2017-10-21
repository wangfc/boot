package com.wfc.boot.support;

import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseService<T>{

    Mapper getMapper();

    void checkMapper ();

    int deleteByPrimaryKey(Object o);

    int delete(T t);

    int insert(T t);

    int insertSelective(T t);

    boolean existsWithPrimaryKey(Object o);

    List<T> selectAll();

    T selectByPrimaryKey(Object o);

    
    int selectCount(T t);

    List<T> select(T t);

    T selectOne(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    int deleteByExample(Object o);

    List<T> selectByExample(Object o);

    int selectCountByExample(Object o);

    int updateByExample(T t, Object o);

    int updateByExampleSelective(T t, Object o);

}
