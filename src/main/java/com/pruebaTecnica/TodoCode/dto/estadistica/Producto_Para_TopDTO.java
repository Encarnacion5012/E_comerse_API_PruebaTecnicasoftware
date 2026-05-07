package com.pruebaTecnica.TodoCode.dto.estadistica;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;

import java.math.BigDecimal;

public record Producto_Para_TopDTO(
        String nombre_Producto,
        BigDecimal precio,
        CategoriaProducto categoriaProducto,
        Long cantidad_Vendida
) {
}
