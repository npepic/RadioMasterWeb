drop database if exists radiomaster;
create database radiomaster charset utf8;
use radiomaster;

create table created_at(
id int not null primary key auto_increment,
datum datetime not null,
timezone_type int not null,
timezone varchar(50) not null

);

create table updated_at(
id int not null primary key auto_increment,
datum datetime not null,
timezone_type int not null,
timezone varchar(50) not null

);

create table user (
id int not null primary key auto_increment,
username varchar(50) not null,
email varchar(50) not null,
password varchar (50) not null, 
created_at int not null,
updated_at int not null
);


create table comments(
id int not null primary key auto_increment,
comments varchar (50) not null,
report_count int not null,        /*PARENT ID MISSING */
created_at datetime,
stations int not null,
user int not null

);

create table stations(
id int not null primary key auto_increment,
name varchar (50) not null,
description varchar (50),
country varchar (50),
website varchar (50),
twitter_url varchar (50),
facebook_url varchar (50),
slug varchar (50),
image_url varchar (50),
thumb_url varchar (50),
stream_url varchar (50),
stream_bitrate varchar (50),
categories varchar (50) not null,
rating int not null,
created_at datetime,
updated_at datetime
);

create table categories(
id int not null primary key auto_increment,
title varchar (50) not null,
description varchar (50),
created_at int not null
);

create table categories_sub(
id int not null primary key auto_increment,
title varchar (50) not null,   /* parent id?? */   /* MISSING TIMEZONE etc. */
description varchar (50),
created_at int not null,
categories int not null
);

create table countries(
id int not null primary key auto_increment,
name varchar (50) not null,
country_code varchar (50) not null,
region varchar (50),
subregion varchar (50),
flag_img_url varchar (50)
);

create unique index ix1 on user(username); 
create unique index ix2 on user(email); 

alter table comments add foreign key(stations) references stations(id);
alter table comments add foreign key(user) references user(id);
alter table categories_sub add foreign key(categories) references categories(id);
alter table categories_sub add foreign key(created_at) references created_at(id);
alter table user add foreign key(created_at) references created_at(id);
alter table user add foreign key(updated_at) references updated_at(id);
alter table categories add foreign key(created_at) references created_at(id);

INSERT INTO created_at(datum,timezone_type,timezone) VALUES
('2016-07-19 06:00:00',3,'Europe/Zagreb'),
('2016-07-19 06:00:00',5,'Europe/Zagreb'),
('2016-07-19 06:00:00',2,'Europe/Zagreb');

INSERT INTO updated_at(datum,timezone_type,timezone) VALUES
('2015-11-01 06:00:00',2,'Europe/Zagreb'),
('2015-07-22 06:00:00',1,'Europe/Zagreb'),
('2014-07-30 06:00:00',7,'Europe/Zagreb');


INSERT INTO user(username,email,password,created_at,updated_at) VALUES 
('npepic','npepic@gmail.com','n',1,2),
('pmilardovic','pmilardovic@gmail.com','p',2,3);


INSERT INTO stations(name,description,country,website,twitter_url,facebook_url,slug,image_url,thumb_url,stream_url,stream_bitrate,categories,rating,created_at,updated_at) VALUES
('Narodni Radio','TestDescription','Croatia','wwww.test.com','twitterTest.com',null,null,null,null,null,null,'News',0,'2016-07-18 06:00:00','2016-07-19 06:00:00'),
('Gradski Radio','TestDescription2','Croatia','www.gradski.hr','gradskiTwitter.com',null,null,null,null,null,null,'News',0,'2016-07-18 06:00:00','2016-07-19 06:00:00'),
('Otvoreni Radio','TestDescription3','Croatia','www.otvoreni,hr',null,null,'testTest',null,null,null,null,'News',0,'2016-07-18 06:00:00','2016-07-19 06:00:00'),
('SW3 Radio','TestDescription4','Germany','www.sw3.de',null,null,null,null,null,null,null,'News',0,'2016-07-18 06:0a:00','2016-07-19 06:00:00');

INSERT INTO comments(comments,report_count,created_at,stations,user) VALUES
('TestComment',0,'2016-07-18 06:00:00',2,1),
('TestComment1',5,'2016-07-18 06:00:00',4,2),
('TestComment2',7,'2016-07-18 06:00:00',3,1),
('TestComment3',3,'2016-07-18 06:00:00',1,2);


INSERT INTO categories(title,description,created_at) VALUES
('TestTitle','TestDescription',1),
('Rock','TestDescription2',2),
('Pop','TestDescription3',3);

INSERT INTO categories_sub(title,description,created_at,categories) VALUES
('TestSub3','TestDescription',1,1),
('TestSub','TestDescription2',2,2),
('TestSub2','TestDescription3',3,3);

INSERT INTO countries(name,country_code,region,subregion,flag_img_url) VALUES
('Croatia','CRO', 'Europe','Middle Europe',null),
('Germany','GER', 'Europe','Middle Europe',null),
('Austria','AUT', 'Europe','Middle Europe',null),
('Andora','AD', 'Europe','Southern Europe',null);