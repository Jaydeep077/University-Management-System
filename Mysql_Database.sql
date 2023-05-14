create database Universitymanagementsystem;
use  Universitymanagementsystem;
create table login(username varchar(30),password varchar(10));
insert into login values("admin","12345");
/*student table*/
create table student
                  ( Registration_Number varchar(10) NOT NULL,
                  Name varchar(50) NOT NULL,
                  Date_of_Birth varchar(15),
                  Email varchar(40),
                  Phone_no varchar(10),
                  Course varchar(40),
                  Branch varchar(40),
                  class_10th_mark_in_percentage varchar(3),
                  class_12th_mark_in_percentage varchar(3),
                  Address varchar(100),
                  primary key(Registration_Number));

 /*faculty table*/
create table Faculty_info
                   ( Name varchar(40),
                   Emp_id varchar(8),
                   DOB varchar(15),
                   Email varchar(40),
                   Phone_no varchar(10),
                   Address varchar(100)
                   primary key(Emp_id));
/*subject table*/
create table subject
                  (Registration_number varchar(10),
                  semester varchar(14),
                  subject1 varchar(3),
                  subject2 varchar(3),
                  subject3 varchar(3),
                  subject4 varchar(3),
                  subject5 varchar(3),  FOREIGN KEY (Registration_number) REFERENCES student(Registration_number));
/*mark table*/
create table mark
               (Registration_number varchar(10),
               semester varchar(14),
               mark1 varchar(3),
               mark2 varchar(3),
               mark3 varchar(3),
               mark4 varchar(3),
               mark5 varchar(3),  FOREIGN KEY (Registration_number) REFERENCES student(Registration_number));
  



    