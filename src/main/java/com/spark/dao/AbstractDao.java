package com.spark.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Spark on 1/24/16.
 */
public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SessionFactory sessionFactory2;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session getSession2() {
        return sessionFactory2.getCurrentSession();
    }

    public void persist(Object entity) {
        getSession().persist(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
