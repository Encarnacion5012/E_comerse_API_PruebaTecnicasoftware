create table users(
id bigint not null GENERATED  ALWAYS AS IDENTITY PRIMARY KEY,
nombre varchar(50) not null,
email varchar(100) not null,
clave varchar(255) not null,
rol varchar(50) not null,
activo boolean not null
)