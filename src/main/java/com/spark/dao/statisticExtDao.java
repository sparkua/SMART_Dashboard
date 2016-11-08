package com.spark.dao;

import javax.sql.DataSource;

/**
 * Created by Spark on 2/18/16.
 */
public interface StatisticExtDao {
    public void getDatamartStatistic( );
    public void setDataSource(DataSource dataSource);
}
