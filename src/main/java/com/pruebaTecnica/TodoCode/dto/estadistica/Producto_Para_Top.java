package com.pruebaTecnica.TodoCode.dto.estadistica;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import com.pruebaTecnica.TodoCode.model.producto.Producto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public record Producto_Para_Top(
        String nombre_Producto,
        BigDecimal precio,
        CategoriaProducto categoriaProducto,
        Long cantidad_Vendida
) {
}
