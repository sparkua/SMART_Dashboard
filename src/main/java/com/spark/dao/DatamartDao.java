package com.spark.dao;

import com.spark.dao.model.StatModel;

import java.util.List;

/**
 * Created by Spark on 4/28/16.
 */
public interface DatamartDao {

    List<StatModel> getStatistic(Integer numDays);

    List<String> getDatamartProcList();
}
