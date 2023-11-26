create table topicos (
    id bigint auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(100) not null,
    fecha_creacion timestamp not null,
    status varchar(100) not null,
    autor_id bigint not null ,
    curso_id bigint not null,

    primary key(id),
    foreign key(autor_id) references usuarios(id),
    foreign key(curso_id) references cursos(id)
);