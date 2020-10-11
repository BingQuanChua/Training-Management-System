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

![ss1](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss1-Login.PNG?raw=true)

![ss2](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss2-AdminUI.PNG?raw=true)

![ss3](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss3-AddNewUser.PNG?raw=true)

![ss4](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss4-ManageTrainingCourse.PNG?raw=true)

![ss5](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss5-AddNewTrainingCourse.PNG?raw=true)

![ss6](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss6-TrainerManageTrainingCourse.PNG?raw=true)

![ss7](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss7-ManageTrainingMaterial.PNG?raw=true)

![ss8](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss8-AvailableTrainingList.PNG?raw=true)

![ss9](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss9-AvailableTrainingList.PNG?raw=true)

![ss10](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss10-TrainingProgress.PNG?raw=true)