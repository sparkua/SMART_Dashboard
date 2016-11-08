package com.spark.dao.impl;

import com.spark.dao.MenuDao;
import com.spark.dao.model.Menu;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Spark on 2/7/16.
 */
@Repository("menuDao")
public class MenuDaoImpl implements MenuDao{

    @Autowired
    @Qualifier("SessionFactory")
    private SessionFactory sessionFactory;

    public MenuDaoImpl() {
    }

    public MenuDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Menu> list() {
        @SuppressWarnings("unchecked")
        /*List<Menu> listMenu = (List<Menu>) sessionFactory.getCurrentSession()
                .createCriteria(Menu.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return listMenu;*/

                Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Menu.class);
        return (List<Menu>) criteria.list();
    }

    @Override
    public Menu get(int id) {
        return null;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Menu menu) {
        sessionFactory.getCurrentSession().saveOrUpdate(menu);
    }

    @Override
    public void delete(int id) {

    }
}
