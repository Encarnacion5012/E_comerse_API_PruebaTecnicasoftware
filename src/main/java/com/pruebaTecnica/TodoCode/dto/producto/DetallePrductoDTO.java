package com.pruebaTecnica.TodoCode.dto.producto;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import com.pruebaTecnica.TodoCode.model.producto.Producto;

import java.math.BigDecimal;

public record DetallePrductoDTO(
        long id,
        String nombre,

        BigDecimal precio,

        int stok,

        CategoriaProducto categoria
) {
    public DetallePrductoDTO(Producto p){
        this(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getStok(),
                p.getCategoria()
        );
    }
}
