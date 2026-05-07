package com.pruebaTecnica.TodoCode.dto.estadistica;

import com.pruebaTecnica.TodoCode.model.producto.Producto;

import java.util.LinkedHashMap;
import java.util.List;

public record TopDTO(
        List<Producto_Para_TopDTO> Top_10
) {
    public TopDTO(LinkedHashMap<Producto, Long> productos){
        this(
               productos.entrySet().stream()
                       .map(e-> new Producto_Para_TopDTO(
                               e.getKey().getNombre(),
                               e.getKey().getPrecio(),
                               e.getKey().getCategoria(),
                               e.getValue()

                       )).toList()
        );
    }
}
