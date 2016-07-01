#CalendarService
##Setup
####1. Setup a Database (with a JDBC driver) with a table that contains the columns

EntryYears

EntryMonth

EntryDay

EntryHours

EntryMinutes

EntrySeconds

Title

Description

Id

###2. Driver Setup
2a. Add your JDBC driver into /WebContent/WEB-INF/Lib

2b. Edit the URL in the DBManager Class

2c. Edit the class loader in the DBManager Class

##Running the service
####1. Run your database server
####2. Run your Tomcat Server
  * If you're running it in Eclipse, just add the project to run on the server
  * If you're running the server separately, export the project as a .war file and place it in your webapps folder

##Using the service
####Base URL: 
http://localhost:8080/CalendarDemo/services/rest/CalendarManager/

|  Function            |  Endpoint          |  Body 																										   		   |
|----------------------|--------------------|--------------------------------------------------------------------------------------------------------------------------|
|  Add an event        |  /insertEntry/     |  {"calendarEntry":{"year":"1","month":"1","day":"1","hours":"1","mins":"1","title":"Event","description":"Great Event"}} |
|  Find an event       |  /findEntryById/   |  {"calendarEntry":{"id"="id of event to retrieve"}}															   		   |
|  Retrieve all events |  /fetchAllEntries/ |  {} 																											   		   |
|  Update an event     |  /updateEntry/     |  {"calendarEntry":{"id"="id of event to update",//any properties you want to update}}							  		   |
|  Delete an event     |  /deleteEntry/     |  {"calendarEntry":{"id"="id of event to delete"}}																   		   |