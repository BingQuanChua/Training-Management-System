DROP DATABASE mjtms;
CREATE DATABASE mjtms;
USE mjtms;

####################
# User Management  #
####################

CREATE TABLE USER (
  USER_ID char(8) NOT NULL,
  USER_NAME varchar(50) ,
  USER_PASS varchar(50) ,
  USER_POS varchar(50) ,
  USER_DESC varchar(200) ,
  USER_GENDER char(1) ,
  USER_CONTACT varchar(20) ,
  USER_EMAIL varchar(50) ,
  USER_TYPE varchar(10),
  PRIMARY KEY (USER_ID)
) ;

CREATE TABLE ADMIN (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
  FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID) ON DELETE CASCADE
) ;

CREATE TABLE TRAINER (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
 FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID) ON DELETE CASCADE
) ;

CREATE TABLE TRAINEE (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
 FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID) ON DELETE CASCADE
) ;

#################
#  Trigger      #
#################

CREATE TRIGGER UpdateTrainee 
    AFTER INSERT  
        ON USER FOR EACH ROW  
        INSERT INTO TRAINEE(USER_ID)
        (SELECT USER.USER_ID FROM USER 
        WHERE USER.USER_ID NOT IN(SELECT TRAINEE.USER_ID FROM TRAINEE) AND USER.USER_TYPE ='trainee');

CREATE TRIGGER UpdateTrainer 
    AFTER INSERT  
        ON USER FOR EACH ROW  
        INSERT INTO TRAINER(USER_ID)
        (SELECT USER.USER_ID FROM USER 
        WHERE USER.USER_ID NOT IN(SELECT TRAINER.USER_ID FROM TRAINER) AND USER.USER_TYPE ='trainer');

INSERT INTO USER VALUES ('adm00001', 'Admin','Admin12345!', 'adminPosition', 'adminDescription', 'm', '999', 'admin@tms.com', 'admin');
INSERT INTO USER VALUES ('tnr00001', 'William','Trainer12345!', 'trainerPosition', 'trainerDescription', 'm', '012-7654321', 'trainer@tms.com', 'trainer');
INSERT INTO USER VALUES ('tnr00002', 'Elizabeth','Trainer12345!', 'trainerPosition', 'trainerDescription', 'f', '012-7654321', 'trainer@tms.com', 'trainer');
INSERT INTO USER VALUES ('tne00001', 'Michael','Trainee12345!', 'traineePosition', 'traineeDescription', 'm', '012-1234567', 'trainee@tms.com', 'trainee');
INSERT INTO USER VALUES ('tne00002', 'Coby','Trainee12345!', null, null, null, null, null, 'trainee');
INSERT INTO USER VALUES ('tne00003', 'Felix','Trainee12345!', null, null, null, null, null, 'trainee');
INSERT INTO USER VALUES ('tne00004', 'Jennifer','Trainee12345!', null, null, null, null, null, 'trainee');

INSERT INTO ADMIN VALUES ('adm00001');

###################################
# Training Course Management      #
###################################

CREATE TABLE TRAINING_COURSE (
COURSE_ID CHAR(8) NOT NULL,
USER_ID CHAR(8) NOT NULL,
COURSE_NAME VARCHAR(50),
COURSE_DESC VARCHAR(200),
COURSE_DATE DATE,
FEEDBACK_LINK VARCHAR(200),
PRIMARY KEY(COURSE_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINER(USER_ID) ON DELETE CASCADE
) ;

CREATE TABLE ENROLL (
USER_ID CHAR(8) NOT NULL,
COURSE_ID CHAR(8) NOT NULL,
TRAINING_STATUS VARCHAR(10),
PRIMARY KEY(USER_ID,COURSE_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINEE(USER_ID) ON DELETE CASCADE,
FOREIGN KEY(COURSE_ID) REFERENCES  TRAINING_COURSE(COURSE_ID) ON DELETE CASCADE
) ;

CREATE TABLE COURSE_MATERIAL(
MATERIAL_ID CHAR(8) NOT NULL,
COURSE_ID CHAR(8) NOT NULL,
MATERIAL_TITLE VARCHAR(50),
MATERIAL_DESC VARCHAR(200),
PRIMARY KEY(MATERIAL_ID),
FOREIGN KEY(COURSE_ID) REFERENCES TRAINING_COURSE(COURSE_ID) ON DELETE CASCADE
) ;

INSERT INTO TRAINING_COURSE VALUES ('crs00001', 'tnr00001','Python Training', 'Basic programming training', '2020-10-14', 'https://docs.google.com/forms/d/e/1FAIpQLSc3B0aW-9Z_wxfZOnrtZLungmz01uF4-YI5EvfFLLN4v4Kzqg/');
INSERT INTO TRAINING_COURSE VALUES ('crs00002', 'tnr00002','Ruby On Rails', 'Learn enough to be dangerous', '2020-10-02', 'https://docs.google.com/forms/d/e/1FAIpQLSc3B0aW-9Z_wxfZOnrtZLungmz01uF4-YI5EvfFLLN4v4Kzqg/');
INSERT INTO TRAINING_COURSE VALUES ('crs00003', 'tnr00002','Andriod Studio', 'Start from a simple app', '2020-10-05', 'https://docs.google.com/forms/d/e/1FAIpQLSc3B0aW-9Z_wxfZOnrtZLungmz01uF4-YI5EvfFLLN4v4Kzqg/');
INSERT INTO TRAINING_COURSE VALUES ('crs00004', 'tnr00002','Introduction to OOAD', 'Learn OOAD with Java', '2020-10-08', 'https://docs.google.com/forms/d/e/1FAIpQLSc3B0aW-9Z_wxfZOnrtZLungmz01uF4-YI5EvfFLLN4v4Kzqg/');

INSERT INTO COURSE_MATERIAL VALUES ('mtr00001', 'crs00001', 'Your first Python code!', 'Hello Word');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00002', 'crs00001', 'Built in data type', 'Variables can store data of different types, and different types can do different things.');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00003', 'crs00001', 'Advanced', 'Object Oriented Programming');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00004', 'crs00002', 'Scaffold ', 'Scaffolding provides more than cheap demo thrills');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00005', 'crs00002', 'Rails Migration ', 'https://www.tutorialspoint.com/ruby-on-rails/rails-migrations.htm');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00006', 'crs00003', 'Installation', 'Download from https://developer.android.com/studio/');
INSERT INTO COURSE_MATERIAL VALUES ('mtr00007', 'crs00004', 'Java version', 'Please download suitable Java version');

INSERT INTO ENROLL VALUES ('tne00002', 'crs00001', 'approved');

########################################
# Progress and Evaluation Management   #
########################################

CREATE TABLE PROGRESS(
USER_ID CHAR(8) NOT NULL,
MATERIAL_ID CHAR(8) NOT NULL,
MATERIAL_IS_DONE  VARCHAR(5),
PRIMARY KEY(USER_ID,MATERIAL_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINEE(USER_ID) ON DELETE CASCADE,
FOREIGN KEY(MATERIAL_ID) REFERENCES COURSE_MATERIAL(MATERIAL_ID) ON DELETE CASCADE
) ;

INSERT INTO PROGRESS VALUES ('tne00002','mtr00001','false');
INSERT INTO PROGRESS VALUES ('tne00002','mtr00002','false');
INSERT INTO PROGRESS VALUES ('tne00002','mtr00003','false');


######## END ######## 


