package com.hdjf.oa.dao;

import com.hdjf.oa.utils.HDLog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * Created by harrishuang on 2017/8/24.
 */
@Transactional
public abstract class BaseDaoImple<T> implements BaseDao<T> {

    Class<T> clazz;


    public BaseDaoImple() {
        ParameterizedType pd = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class<T>) pd.getActualTypeArguments()[0];

    }


    @Resource
    private SessionFactory sessionFactory;


    public void add(T entity) {

        HDLog.info(entity);
        Session session = getSession();
        Transaction tx = session.beginTransaction();

        Serializable save = session.save(entity);
        tx.commit();
        HDLog.info(save);

    }

    public void delete(T entity) {
        Session session = getSession();
        session.delete(entity);

    }

    public void update(T entity) {
        Session session = getSession();
        session.update(entity);
    }

    public List<T> getByIds(Long[] ids) {
        if (ids == null || ids.length == 0) {
            return Collections.EMPTY_LIST;
        }

        return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)").setParameterList("ids", ids)
                .list();
    }

    public T getByiId(Long id) {
        return (T) getSession().get(clazz, id);
    }

    public List<T> findAll() {
        return getSession().createQuery("FROM " + clazz.getSimpleName()).list();
    }

    private Session getSession() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession;

    }


}
