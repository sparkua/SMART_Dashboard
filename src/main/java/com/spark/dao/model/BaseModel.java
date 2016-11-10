package com.spark.dao.model;

import java.util.List;

/**
 * Created by Spark on 5/15/16.
 */
public class BaseModel implements java.io.Serializable{

    String applicationName;

    Integer successfullJobCount;
    Integer inprogressJobCount;
    Integer failedJobCount;
    Integer numberOfDaysStat;

    List<String> procNameList;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Integer getSuccessfullJobCount() {
        return successfullJobCount;
    }

    public void setSuccessfullJobCount(Integer successfullJobCount) {
        this.successfullJobCount = successfullJobCount;
    }

    public Integer getInprogressJobCount() {
        return inprogressJobCount;
    }

    public void setInprogressJobCount(Integer inprogressJobCount) {
        this.inprogressJobCount = inprogressJobCount;
    }

    public Integer getFailedJobCount() {
        return failedJobCount;
    }

    public void setFailedJobCount(Integer failedJobCount) {
        this.failedJobCount = failedJobCount;
    }

    public Integer getNumberOfDaysStat() {
        return numberOfDaysStat;
    }

    public void setNumberOfDaysStat(Integer numberOfDaysStat) {
        this.numberOfDaysStat = numberOfDaysStat;
    }

    public List<String> getProcNameList() {
        return procNameList;
    }

    public void setProcNameList(List<String> procNameList) {
        this.procNameList = procNameList;
    }
}
