# Michael Jackson Training Management System 

![banner](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/banner.PNG?raw=true)

## Opening project in Eclipse

In Eclipse, File > Import

In General > Existing Projects into Workspace

Click "Browse", select Michael Jackson as root directory

The IDE will recognize it as an Eclipse project

Click "Finish"



## Setting up MySQL database connection

<u>Step 1:</u> Create a database in your local machine

Go to tms\MichaelJackson

Open mjtms.SQL

In MySQL Workbench, Query > Reconnect to Server

Highlight all the syntax and click the "⚡" icon, executing all the queries (and setting a few dummy data)



<u>Step 2:</u> Making a connection to the database

Notice that there is a text file "JDBCinfo.txt" in the model package

Create a new java class in the same package with the same name

Change the serverPassword field to your password



## Running the Program


To run the program, simply run Main.java

#note : dummy user accounts (from database)

| Type of User | User_ID  | Password      |
| ------------ | -------- | ------------- |
| Admin        | adm00001 | Admin12345!   |
| Trainer      | tnr00001 | Trainer12345! |
| Trainee      | tne00001 | Trainee12345! |



## Screenshots

~
