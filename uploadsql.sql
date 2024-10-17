create database if not exists upload;
use upload;
create table if not exists usuario(
	id bigint auto_increment primary key,
    nome varchar(200),
    picole_favorito varchar(200),
    image_url varchar(200)
);






