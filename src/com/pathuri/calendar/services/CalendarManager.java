package com.pathuri.calendar.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pathuri.calendar.model.CalendarRequest;
import com.pathuri.calendar.model.CalendarResponse;

@Consumes("application/json")
@Produces("application/json")
public interface CalendarManager
{
	@POST
	@Path("/fetchEntryById/")
	public CalendarResponse fetchEntryById(CalendarRequest request);

	@POST
	@Path("/fetchAllEntries/")
	public CalendarResponse fetchAllEntries(CalendarRequest request);

	@POST
	@Path("/insertEntry/")
	public CalendarResponse insertEntry(CalendarRequest request);

	@POST
	@Path("/updateEntry/")
	public CalendarResponse updateEntry(CalendarRequest request);

	@POST
	@Path("/deleteEntry/")
	public CalendarResponse deleteEntry(CalendarRequest request);
}