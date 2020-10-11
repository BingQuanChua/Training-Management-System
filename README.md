# Michael Jackson Training Management System 

![banner](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/banner.PNG?raw=true)

## Opening project in Eclipse

In Eclipse, File > Import

In General > Existing Projects into Workspace

Click "Browse", select Michael Jackson as root directory

The IDE will recognize it as an Eclipse project

Click "Finish"



## Setting up MySQL database connection

<ins>Step 1:</ins> Create a database in your local machine

Go to tms\MichaelJackson

Open mjtms.SQL

In MySQL Workbench, Query > Reconnect to Server

Highlight all the syntax and click the "⚡" icon, executing all the queries (and setting a few dummy data)



<ins>Step 2:</ins> Making a connection to the database

Notice that there is a text file "JDBCinfo.txt" in the model package

Create a new java class in the same package with the same name

Change the serverPassword field to your password



## Running the Program

To run the program, simply run Main.java (click the green play button on top)

You may log in the system with the accounts below: (dummy data from creation)

| Type of User | User_ID  | Password      |
| ------------ | -------- | ------------- |
| Admin        | adm00001 | Admin12345!   |
| Trainer      | tnr00001 | Trainer12345! |
| Trainee      | tne00001 | Trainee12345! |



## Screenshots

![ss1](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss1-Login.png?raw=true)

![ss2](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss2-AdminUI.png?raw=true)

![ss3](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss3-AddNewUser.png?raw=true)

![ss4](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss4-ManageTrainingCourse.png?raw=true)

![ss5](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss5-AddNewTrainingCourse.png?raw=true)

![ss6](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss6-TrainerManageTrainingCourse.png?raw=true)

![ss7](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss7-ManageTrainingMaterial.png?raw=true)

![ss8](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss8-AvailableTrainingList.png?raw=true)

![ss9](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss9-AvailableTrainingList.png?raw=true)

![ss10](https://github.com/BingQuanChua/tms/blob/master/MichaelJackson/screenshot/ss10-TrainingProgress.png?raw=true)

## Future Extension or Improvement

- Binary files for training course material

- Upgrade progress feedback 

- Platform independent update
