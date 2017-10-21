package com.wfc.boot.support;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T> implements  BaseService<T> ,InitializingBean{

    public BaseServiceImpl(){
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        checkMapper();
    }

    @Override
    public void checkMapper() {
        if (getMapper() == null ){
            throw  new RuntimeException(" ‘mapper’ can not be null "); // 
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByPrimaryKey(Object o) {
        return getMapper().deleteByPrimaryKey(o);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int delete(T t) {
        return getMapper().delete(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insert(T t){
       int i = getMapper().insert(t);
        return i;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertSelective(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public boolean existsWithPrimaryKey(Object o) {
        return getMapper().existsWithPrimaryKey(o);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<T> selectAll() {
        return getMapper().selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public T selectByPrimaryKey(Object o) {
        return(T) getMapper().selectByPrimaryKey(o);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public int selectCount(T t) {
        return getMapper().selectCount(t);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public List<T> select(T t) {
        return getMapper().select(t);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
    public T selectOne(T t) {
        return (T) getMapper().selectOne(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateByPrimaryKey(T t) {
        return getMapper().updateByPrimaryKey(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteByExample(Object o) {
        return getMapper().deleteByExample(o);
    }

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public List<T> selectByExample(Object o) {
        return getMapper().selectByExample(o);
    }

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public int selectCountByExample(Object o) {
        return getMapper().selectCountByExample(o);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateByExample(T t, Object o) {
        return getMapper().updateByExample(t,o);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updateByExampleSelective(T t, Object o) {
        return getMapper().updateByExampleSelective(t,0);
    }
}
