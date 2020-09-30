CREATE DATABASE mjtms;
USE mjtms;

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

INSERT INTO USER VALUES ('adm00001', 'adminName','admin1234', 'adminPosition', 'adminDescription', 'm', '999', 'admin@tms.com', 'admin');
INSERT INTO USER VALUES ('tnr00001', 'trainerName','trainer1234', 'trainerPosition', 'trainerDescription', 'f', '012-7654321', 'trainer@tms.com', 'trainer');
INSERT INTO USER VALUES ('tne00001', 'traineeName','trainee1234', 'traineePosition', 'traineeDescription', 'm', '012-1234567', 'trainee@tms.com', 'trainee');

SELECT * FROM USER;

CREATE TABLE ADMIN (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
) ;

CREATE TABLE TRAINER (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
 FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
) ;

CREATE TABLE TRAINEE (
  USER_ID char(8) NOT NULL,
  PRIMARY KEY (USER_ID),
 FOREIGN KEY(USER_ID) REFERENCES USER(USER_ID)
) ;

CREATE TABLE TRAINING_COURSE (
COURSE_ID CHAR(8) NOT NULL,
USER_ID CHAR(8) NOT NULL,
COURSE_NAME VARCHAR(50),
COURSE_DESC VARCHAR(200),
COURSE_DATE DATE,
PRIMARY KEY(COURSE_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINER(USER_ID)
) ;

CREATE TABLE `JOIN` (
USER_ID CHAR(8) NOT NULL,
COURSE_ID CHAR(8) NOT NULL,
TRAINING_STATUS VARCHAR(10),
PRIMARY KEY(USER_ID,COURSE_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINEE(USER_ID),
FOREIGN KEY(COURSE_ID) REFERENCES  TRAINING_COURSE(COURSE_ID)
) ;

CREATE TABLE COURSE_MATERIAL(
MATERIAL_ID CHAR(8) NOT NULL,
COURSE_ID CHAR(8) NOT NULL,
MATERIAL_TITLE VARCHAR(50),
MATERIAL_DESC VARCHAR(200),
PRIMARY KEY(MATERIAL_ID),
FOREIGN KEY(COURSE_ID) REFERENCES TRAINING_COURSE(COURSE_ID)
) ;

CREATE TABLE REPORT(
REPORT_ID CHAR(8) NOT NULL,
COURSE_ID CHAR(8) NOT NULL,
PRIMARY KEY(REPORT_ID),
FOREIGN KEY(COURSE_ID) REFERENCES TRAINING_COURSE(COURSE_ID)
) ;

CREATE TABLE PROGRESS(
USER_ID CHAR(8) NOT NULL,
MATERIAL_ID CHAR(8) NOT NULL,
MATERIAL_IS_DONE  VARCHAR(5),
PRIMARY KEY(USER_ID,MATERIAL_ID),
FOREIGN KEY(USER_ID) REFERENCES TRAINEE(USER_ID),
FOREIGN KEY(MATERIAL_ID) REFERENCES COURSE_MATERIAL(MATERIAL_ID)
) ;




