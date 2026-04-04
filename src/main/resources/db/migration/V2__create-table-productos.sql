create table productos(
id bigint not null GENERATED  ALWAYS AS IDENTITY PRIMARY KEY,
nombre varchar(50) not null,
stok int,
precio DECIMAL,
activo boolean not null,
categoria varchar(30)
)

