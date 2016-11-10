package com.spark.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.spark.dao.model.Views;

public class AjaxResponseBody {
	@JsonView(Views.Public.class)
	String msg;
	
	@JsonView(Views.Public.class)
	String code;
	
	@JsonView(Views.Public.class)
	List<DashboardForm> result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<DashboardForm> getResult() {
		return result;
	}

	public void setResult(List<DashboardForm> result) {
		this.result = result;
	}
	
}
