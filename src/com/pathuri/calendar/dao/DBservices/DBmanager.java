package com.pathuri.calendar.dao.DBservices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pathuri.calendar.model.CalendarEntry;

public class DBmanager {
	private static String dbURL = "jdbc:derby://127.0.0.1//Users/saipathuri/Development/MyDB;user=saipathuri;password=calendarservice";
 	private static String tableName = "Calendar.entries";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    public DBmanager(){
    	createConnection();
    }
    
    public void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   
    public CalendarEntry fetchEntryById(int id){
	   CalendarEntry entry = new CalendarEntry();
	   ArrayList<CalendarEntry> entries = new ArrayList<CalendarEntry>();
	   try
	   {
		   stmt = conn.createStatement();
		   String query = "select DESCRIPTION, TITLE, ENTRYMINUTES, ENTRYHOURS, ENTRYDAY, ENTRYMONTH, ENTRYYEAR, ID from " + tableName 
				   + " where Id=" + id;
		   ResultSet results = stmt.executeQuery(query);
		   
		   entries = parseResultSet(results);
		   entry = entries.get(0);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return entry;
   }
   
    public ArrayList<CalendarEntry> fetchAllEntries()
    {	
    	ArrayList<CalendarEntry> entries = new ArrayList<CalendarEntry>();
        try
        {
            stmt = conn.createStatement();
            String query = "select DESCRIPTION, TITLE, ENTRYMINUTES, ENTRYHOURS, ENTRYDAY, ENTRYMONTH, ENTRYYEAR, ID from ";
            ResultSet results = stmt.executeQuery(query + tableName);
//            ResultSetMetaData rsmd = results.getMetaData();
//            int numberCols = rsmd.getColumnCount();
//            for (int i=1; i<=numberCols; i++)
//            {
//                //print Column Names
//                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
//            }
//
//            System.out.println("\n-------------------------------------------------");

            entries = parseResultSet(results);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
        
        return entries;
    }
    
    public void insertEntry(CalendarEntry e)
    {
	   String desc = e.getDescription();
	   String title = e.getTitle();
	   int mins = e.getMins();
	   int hours = e.getHours();
	   int day = e.getDay();
	   int month = e.getMonth();
	   int year = e.getYear();
	   int id = e.getId();
        try
        {
        	stmt = conn.createStatement();
        	String query = "insert into " + tableName + " (DESCRIPTION, TITLE, ENTRYMINUTES, ENTRYHOURS, ENTRYDAY, ENTRYMONTH, ENTRYYEAR, ID)" 
            + " VALUES ('" + desc + "','" + title + "'," + mins + "," + hours + "," + day + "," + month + "," + year + "," + id + ")";
        	stmt.execute(query);
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    public ArrayList<CalendarEntry> parseResultSet(ResultSet results){
	   ArrayList<CalendarEntry> entries = new ArrayList<CalendarEntry>();
	   
	   try{
		   while(results.next())
	       {
			   	CalendarEntry entry = new CalendarEntry();
	   	
			   	String desc = results.getString("DESCRIPTION");
			   	String title = results.getString("TITLE");
			   	int minutes = results.getInt("ENTRYMINUTES");
			   	int hours = results.getInt("ENTRYHOURS");
			   	int day = results.getInt("ENTRYDAY");
			   	int month = results.getInt("ENTRYMONTH");
			   	int year = results.getInt("ENTRYYEAR");
			   	int id = results.getInt("ID");
		       
			   	entry.setDescription(desc);
			   	entry.setTitle(title);
			   	entry.setMins(minutes);
			   	entry.setHours(hours);
			   	entry.setDay(day);
			   	entry.setMonth(month);
			   	entry.setYear(year);
			   	entry.setId(id);
			   	entry.setStartDate();
			   	entry.setDate();
		       
			   	entries.add(entry);
	       }
	       results.close();
	   }
	   catch(SQLException e){
		   e.printStackTrace();
	   }
       return entries;
   }
    
    public void updateEntry(CalendarEntry entry){
	   	String desc = entry.getDescription();
	   	String title = entry.getTitle();
	   	int mins = entry.getMins();
	   	int hours =	entry.getHours();
	   	int day = entry.getDay();
	   	int month = entry.getMonth();
	   	int year = entry.getYear();
	   	int id = entry.getId();
	   try
	   {
		   stmt = conn.createStatement();
		   String query = "UPDATE " + tableName
				   + " SET DESCRIPTION='" + desc + "',TITLE='" + title + "',ENTRYMINUTES=" + mins + ",ENTRYHOURS=" + hours + ",ENTRYDAY="
				   + day + ",ENTRYMONTH=" + month + ",ENTRYYEAR=" + year + ",ID=" + id
				   + "WHERE ID=" + id;
		   stmt.execute(query);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
   }
    
    public void deleteEntry(CalendarEntry entry){
	   	int id = entry.getId();
	   try
	   {
		   stmt = conn.createStatement();
		   String query = "DELETE FROM " + tableName
				   + " WHERE ID=" + id;
		   stmt.execute(query);
	   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
    }
    
    public void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }
}