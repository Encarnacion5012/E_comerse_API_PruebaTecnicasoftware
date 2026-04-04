CREATE TABLE detalle_ventas (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sub_total DECIMAL(19,2),
    id_producto BIGINT NOT NULL,
    id_venta BIGINT NOT NULL,
    cantidad int not null,
    CONSTRAINT fk_producto FOREIGN KEY (id_producto) REFERENCES productos(id),
    CONSTRAINT fk_venta FOREIGN KEY (id_venta) REFERENCES ventas(id)
);