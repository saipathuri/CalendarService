package com.pathuri.calendar.model;

import java.util.Date;

public class CalendarEntry {
	private Integer id;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hours;
	private Integer mins;
	private Date startDate;
	private String title;
	private String description;
	private String date;
	
//	public CalendarEntry(int year, int month, int day, int hours, int mins, String title, String description) {
//		this.year = year;
//		this.month = month;
//		this.day = day;
//		this.hours = hours;
//		this.mins = mins;
//		this.startDate = new Date(year, month, day, hours, mins);
//		this.title = title;
//		this.description = description;
//	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getMins() {
		return mins;
	}

	public void setMins(Integer mins) {
		this.mins = mins;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate() {
		this.startDate = new Date(year, month, day, hours, mins);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
	
	public String getDate(){
		return date;
	}
	
	public String setDate(){
		String s = getMonth() + "/" + getDay() + "/" + getYear();
		return s;
	}
}
