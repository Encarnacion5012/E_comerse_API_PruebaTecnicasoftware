create table ventas(
id bigint not null GENERATED  ALWAYS AS IDENTITY PRIMARY KEY,
total DECIMAL not null,
fecha_venta TIMESTAMP WITHOUT TIME ZONE not null,
id_sucursal bigint not null,

CONSTRAINT fk_sucursal FOREIGN KEY (id_sucursal) REFERENCES sucursales(id)

)

