package com.spark.dao.model;


import java.sql.Timestamp;

/**
 * Created by Spark on 3/21/16.
 */
public class StatModel extends BaseModel implements java.io.Serializable {

    private Integer jobRunLogID;

    private Timestamp jobStartDT;

    private Timestamp jobEndDT;

    private String  durationTimeStatus;

    private String durationTime;

    private String durationTimeMS;

    private String stepName;


    public Integer getJobRunLogID() {
        return jobRunLogID;
    }

    public void setJobRunLogID(Integer jobRunLogID) {
        this.jobRunLogID = jobRunLogID;
    }

    public String getDurationTimeStatus() {
        return durationTimeStatus;
    }

    public void setDurationTimeStatus(String durationTimeStatus) {
        this.durationTimeStatus = durationTimeStatus;
    }

    public String getDurationTimeMS() {
        return durationTimeMS;
    }

    public void setDurationTimeMS(String durationTimeMS) {
        this.durationTimeMS = durationTimeMS;
    }

    public Timestamp getJobStartDT() {
        return jobStartDT;
    }

    public void setJobStartDT(Timestamp jobStartDT) {
        this.jobStartDT = jobStartDT;
    }

    public Timestamp getJobEndDT() {
        return jobEndDT;
    }

    public void setJobEndDT(Timestamp jobEndDT) {
        this.jobEndDT = jobEndDT;
    }

    public String getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(String durationTime) {
        this.durationTime = durationTime;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }
}
