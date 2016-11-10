package com.spark.service.impl;

import com.spark.AppConstants;
import com.spark.dao.DatamartDao;
import com.spark.dao.model.StatModel;
import com.spark.service.DatamartService;
import com.spark.web.model.DashboardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

/**
 * Created by Spark on 4/28/16.
 */
@Service
public class DatamartServiceImpl implements DatamartService {

    @Autowired
    private DatamartDao datamartDao;

    public DashboardForm getStatistic(Integer numDays) {
        return convert(datamartDao.getStatistic(numDays));
    }

    public List<String> getDatamartProcList() {
        return datamartDao.getDatamartProcList();
    }

    public DashboardForm convert(List<StatModel> statModel){
        DashboardForm dform = new DashboardForm();
        Long avDure = 3600000l;

        Integer countSuccess = 0;
        Integer countFailed = 0;
        Integer countLongRunning = 0;
        Integer countExtraLongRunning = 0;
        Set<String> procList = new HashSet();

        System.out.printf("Average duration: " + avDure.toString());

        for (StatModel stat : statModel) {
            if (AppConstants.DATAMART_ERROR_STATUS.equals(stat.getDurationTimeStatus()))
                countFailed++;
            else
                countSuccess++;
            procList.add(stat.getStepName());

            if (stat.getJobEndDT() == null)
                stat.setJobEndDT(new Timestamp(Calendar.getInstance().getTime().getTime()));

            if (stat.getJobEndDT()!=null && stat.getJobStartDT()!=null && (stat.getJobEndDT().getTime()-stat.getJobStartDT().getTime()) > avDure)
                countLongRunning++;
            if (stat.getJobEndDT()!=null && stat.getJobStartDT()!=null && (stat.getJobEndDT().getTime()-stat.getJobStartDT().getTime()) > (avDure*3))
                countExtraLongRunning++;
        }

        dform.setTotalFailed(countFailed);
        dform.setTotalSuccess(countSuccess);
        dform.setTotalLongRunning(countLongRunning);
        dform.setTotalExtraLongRunning(countExtraLongRunning);
        dform.setAllProcsList(procList);

        return dform;
    }

}
