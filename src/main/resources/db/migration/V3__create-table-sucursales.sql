create table sucursales(
id bigint NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
nombre varchar(50) not null,
direccion varchar(200)
)