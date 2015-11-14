package com.OCare.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mark on 6/30/15.
 */
public abstract class IGeneralDAOImpl<T> implements IGeneralDAO<T> {
    private Class<T> entityClass;

    public IGeneralDAOImpl(Class<T> clazz) {
        this.entityClass = clazz;
    }

    @Autowired
    protected    SessionFactory sessionFactory;

    @Override
    public void insert(T t) {
        sessionFactory.getCurrentSession().save(t);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    @Override
    public void update(T t) {
        sessionFactory.getCurrentSession().update(t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T queryById(String id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public T queryByIntId(int id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass,id);
    }

    @Override
    public List<T> queryAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
        return criteria.list();
    }

}
