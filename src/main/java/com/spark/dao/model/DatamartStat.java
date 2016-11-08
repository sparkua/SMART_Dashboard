package com.spark.dao.model;

import javax.persistence.Id;

/**
 * Created by Spark on 2/18/16.
 */
public class DatamartStat {

    private int id;
    private String JobName;
    private String Time;

    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + JobName + "]";
    }
}
