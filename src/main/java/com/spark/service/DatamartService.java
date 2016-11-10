package com.spark.service;

import com.spark.dao.model.StatModel;
import com.spark.web.model.DashboardForm;

import java.util.List;

/**
 * Created by Spark on 4/28/16.
 */
public interface DatamartService {

    DashboardForm getStatistic(Integer numDays);

    List<String> getDatamartProcList();
}
