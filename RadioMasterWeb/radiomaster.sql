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

create table created_at (
id int not null primary key auto_increment,
date datetime not null,
timezone_type int not null,
timezone varchar (20) not null
);

create table updated_at (
id int not null primary key auto_increment,
date datetime not null,
timezone_type int not null,
timezone varchar (20) not null
);

create unique index ix1 on user(username); 


insert into user(id,username,email,password,created_at,updated_at) values 
(1,'npepic','npepic@gmail.com',md5('n'),'2016-07-18 06:00:00','2016-07-19 06:00:00');


