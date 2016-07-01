package com.pathuri.calendar.model;

import java.util.List;

public class CalendarResponse {
	private List entries;
	private String errorMessage;
	private Boolean success = true;
	
	public List getEntries() {
		return entries;
	}
	public void setEntries(List entries) {
		this.entries = entries;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Boolean isSuccess() {
		return success;
	}
	public void setSuccess(Boolean s){
		success = s;
	}
}
