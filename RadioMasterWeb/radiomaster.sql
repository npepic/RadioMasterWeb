drop database if exists radiomaster;
create database radiomaster charset utf8;
use radiomaster;

create table user (
id int not null primary key auto_increment,
username varchar(50) not null,
email varchar(50) not null,
password varchar (50) not null, 
created_at int not null,
updated_at int not null

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

alter table user add foreign key (created_at) references created_at(id);
alter table user add foreign key (updated_at) references updated_at(id);

insert into created_at(id,date,timezone_type,timezone) values 
(1,'2016-07-18 06:00:00',1,'Europe/Zagreb');

insert into updated_at(id,date,timezone_type,timezone) values 
(1,'2016-07-18 07:00:00',1,'Europe/Zagreb');

insert into user(id,username,email,password,created_at,updated_at) values 
(1,'npepic','npepic@gmail.com',md5('n'),1,1);


