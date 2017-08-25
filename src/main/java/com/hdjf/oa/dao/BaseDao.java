package com.hdjf.oa.dao;

import java.util.List;

/**
 * Created by harrishuang on 2017/8/24.
 */
public interface BaseDao<T> {

    void add(T entity);

    void delete(T entity);

    void update(T entity);

    List<T> getByIds(Long[] ids);

    T getByiId(Long id);

    List<T> findAll();
}
