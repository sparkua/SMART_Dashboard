package com.spark.dao.impl;

import com.spark.dao.DataDao;
import com.spark.dao.model.Data;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Spark on 2/8/16.
 */
@Repository("dataDao")
public class DataDaoImpl implements DataDao {

    @Autowired
    @Qualifier("SessionFactory")
    private SessionFactory sessionFactory;

    public DataDaoImpl() {

    }

    public DataDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Data> list() {
        @SuppressWarnings("unchecked")
        /*List<Menu> listMenu = (List<Menu>) sessionFactory.getCurrentSession()
                .createCriteria(Menu.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listMenu;*/

                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Data.class);
        return (List<Data>) criteria.list();
    }

    @Override
    public Data get(int id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Data data) {

    }

    @Override
    public void delete(int id) {

    }
}
