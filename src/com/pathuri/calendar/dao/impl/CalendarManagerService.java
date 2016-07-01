package com.pathuri.calendar.dao.impl;

import com.pathuri.calendar.*;
import com.pathuri.calendar.dao.CalendarManagerDao;
import com.pathuri.calendar.model.CalendarRequest;
import com.pathuri.calendar.model.CalendarResponse;
import com.pathuri.calendar.services.CalendarManager;

import java.util.Arrays;

public class CalendarManagerService implements CalendarManager {
	private CalendarManagerDao calendarDao;

	public CalendarManagerDao getCalendarDao()
	{
		return calendarDao;
	}

	public void setCalendarDao(CalendarManagerDao calendarDao)
	{
		this.calendarDao = calendarDao;
	}

	public CalendarResponse fetchEntryById(CalendarRequest request)
	{
		CalendarResponse response = new CalendarResponse();

		try
		{
			response.setEntries(Arrays.asList(getCalendarDao().fetchEntryById(
				request.getCalendarEntry().getId())));
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public CalendarResponse fetchAllEntries(CalendarRequest request)
	{
		CalendarResponse response = new CalendarResponse();

		try
		{
			response.setEntries(getCalendarDao().fetchAllEntries());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public CalendarResponse insertEntry(CalendarRequest request)
	{
		CalendarResponse response = new CalendarResponse();

		try
		{
			getCalendarDao().insertEntry(request.getCalendarEntry());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

	public CalendarResponse updateEntry(CalendarRequest request)
	{
		CalendarResponse response = new CalendarResponse();

		try
		{
			getCalendarDao().updateEntry(request.getCalendarEntry());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}

	public CalendarResponse deleteEntry(CalendarRequest request)
	{
		CalendarResponse response = new CalendarResponse();

		try
		{
			getCalendarDao().deleteEntry(request.getCalendarEntry());
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setErrorMessage(e.getClass() + ": " + e.getMessage());
		}

		return response;
	}
}
