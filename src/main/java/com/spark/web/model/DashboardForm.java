package com.spark.web.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.spark.dao.model.Views;

public class DashboardForm {

	public DashboardForm(){
	}

    @JsonView(Views.Normal.class)
    private Integer totalProcCount;

    @JsonView(Views.Normal.class)
    private Integer totalSuccess;

    @JsonView(Views.Normal.class)
    private Integer totalFailed;

    @JsonView(Views.Normal.class)
    private Integer totalLongRunning;

    @JsonView(Views.Normal.class)
    private Integer totalExtraLongRunning;

    @JsonView(Views.Normal.class)
    private Set<String> allProcsList;

    public Integer getTotalLongRunning() {
        return totalLongRunning;
    }

    public Integer getTotalExtraLongRunning() {
        return totalExtraLongRunning;
    }

    public void setTotalExtraLongRunning(Integer totalExtraLongRunning) {
        this.totalExtraLongRunning = totalExtraLongRunning;
    }

    public void setTotalLongRunning(Integer totalLongRunning) {
        this.totalLongRunning = totalLongRunning;
    }

    public Integer getTotalProcCount() {
        return totalProcCount;
    }
    public void setTotalProcCount(Integer totalProcCount) {
        this.totalProcCount = totalProcCount;
    }

    public Integer getTotalSuccess() {
        return totalSuccess;
    }
    public void setTotalSuccess(Integer totalSuccess) {
        this.totalSuccess = totalSuccess;
    }

    public Integer getTotalFailed() {
        return totalFailed;
    }
    public void setTotalFailed(Integer totalFailed) {
        this.totalFailed = totalFailed;
    }

    public Set<String> getAllProcsList() {
        return allProcsList;
    }

    public void setAllProcsList(Set<String> allProcsList) {
        this.allProcsList = allProcsList;
    }

}
