
drop database if exists radiomaster;
create database radiomaster charset utf8;
use radiomaster;

create table user (
id int not null primary key auto_increment,
username varchar(50) not null,
email varchar(50) not null,
password varchar (50) not null, 
created_at datetime,
updated_at datetime

);

create unique index ix1 on user(username); 
create unique index ix2 on user(email); 


INSERT INTO user(username,email,password,created_at,updated_at) values 
('npepic','npepic@gmail.com','n','2016-07-18 06:00:00','2016-07-19 06:00:00'),
('pmilardovic','pmilardovic@gmail.com','p','2016-07-18 06:00:00','2016-07-18 06:00:00');


