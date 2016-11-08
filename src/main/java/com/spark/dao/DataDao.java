package com.spark.dao;

import com.spark.dao.model.Data;

import java.util.List;

/**
 * Created by Spark on 2/8/16.
 */
public interface DataDao {

    public List<Data> list();

    public Data get(int id);

    public void saveOrUpdate(Data data);

    public void delete(int id);
}
