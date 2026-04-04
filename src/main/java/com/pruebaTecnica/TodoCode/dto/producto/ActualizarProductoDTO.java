package com.pruebaTecnica.TodoCode.dto.producto;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;

import java.math.BigDecimal;

public record ActualizarProductoDTO(

        String nombre,

        BigDecimal precio,

        int stok,

        CategoriaProducto categoria
) {
}
