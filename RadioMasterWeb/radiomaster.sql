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


insert into user(id,username,email,password,created_at,updated_at) values 
(1,'npepic','npepic@gmail.com',md5('n'),'2016-07-18 06:00:00','2016-07-19 06:00:00');

create table countries (
id int not null primary key auto_increment,
name varchar(50) not null,
country_code varchar(50) not null,
region varchar (50) not null,
subregion varchar (50) not null,
flag_img_url varchar (50) not null
);

create table categories (
id int not null primary key auto_increment,
title varchar(50) not null,
description varchar(50) not null,
created_at datetime
);

create table stations (
id int not null primary key auto_increment,
rating varchar(50) not null,
name varchar(50) not null,
updated_at datetime
);

