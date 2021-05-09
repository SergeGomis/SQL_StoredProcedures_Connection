# SQL_StoredProcedures_Connection using SpringBoot
web page that displays the data received from the web service and rechecks for changes every 5-10 seconds. 
Use a text field (or something else with the same functionality) on the Page, which allows to type an ID (IDX). 
This ID will be the IDX parameter of GetX(int IDX) stored procedure. If the text field is empty (blank), 
the IDX value will be null. Please create a Button, like “Execute” to execute the stored procedure with the value typed in text field.
