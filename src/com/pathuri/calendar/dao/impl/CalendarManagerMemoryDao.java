package com.pathuri.calendar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.pathuri.calendar.dao.CalendarManagerDao;
import com.pathuri.calendar.model.CalendarEntry;
import com.pathuri.calendar.dao.DBservices.DBmanager;

public class CalendarManagerMemoryDao implements CalendarManagerDao{
	private int nextCalendarEntryId = 0;

	List<CalendarEntry> entries = new ArrayList<CalendarEntry>();
	DBmanager db = new DBmanager();
	

	public CalendarEntry fetchEntryById(Integer id){
//		for (CalendarEntry entry : entries){
//			if (entry.getId() == id){
//				return entry;
//			}
//		}
//		throw new RuntimeException("Entry Not Found: " + id);
		CalendarEntry entry = db.fetchEntryById(id);
		if(entry.getId() == id)
			return entry;
		throw new RuntimeException("Entry not found");
	}

	public List fetchAllEntries(){
		return db.fetchAllEntries();
	}

	public void insertEntry(CalendarEntry entry){
		entry.setId(nextCalendarEntryId++);
		db.insertEntry(entry);
//		entries.add(entry);
	}

	public void updateEntry(CalendarEntry entry){
		db.updateEntry(entry);
	}

	public void deleteEntry(CalendarEntry entry){
		CalendarEntry delCalendarEntry = fetchEntryById(entry.getId());
		db.deleteEntry(delCalendarEntry);
	}
}