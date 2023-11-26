create table usuarios(
    id bigint auto_increment,
    nombre varchar(300) not null,
    email varchar(100) unique not null,
    contraseña varchar(300) not null,

    primary key(id)
);