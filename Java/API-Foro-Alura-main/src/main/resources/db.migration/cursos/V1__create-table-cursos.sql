create table cursos(
    id bigint auto_increment,
    nombre varchar(100) unique not null,
    categoria varchar(100) not null,

    primary key(id)
);