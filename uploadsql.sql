create database if not exists upload;
use upload;
create table if not exists usuario(
	id bigint auto_increment primary key,
    image_url varchar(200)
);



