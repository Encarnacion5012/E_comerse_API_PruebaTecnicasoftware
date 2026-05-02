package com.pruebaTecnica.TodoCode.dto.estadistica;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import com.pruebaTecnica.TodoCode.model.producto.Producto;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

public record Top_10(
        List<Producto_Para_Top> Top_10
) {
    public Top_10(LinkedHashMap<Producto, Long> productos){
        this(
               productos.entrySet().stream()
                       .limit(10)
                       .map(e-> new Producto_Para_Top(
                               e.getKey().getNombre(),
                               e.getKey().getPrecio(),
                               e.getKey().getCategoria(),
                               e.getValue()

                       )).toList()
        );
    }
}
