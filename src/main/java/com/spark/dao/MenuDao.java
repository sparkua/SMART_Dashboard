package com.spark.dao;

import com.spark.dao.model.Menu;

import java.util.List;

/**
 * Created by Spark on 1/24/16.
 */
public interface MenuDao
{
    public List<Menu> list();

    public Menu get(int id);

    public void saveOrUpdate(Menu menu);

    public void delete(int id);
}
