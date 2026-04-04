package com.pruebaTecnica.TodoCode.dto.producto;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RegistarProductoDTO(
       @NotBlank String nombre,

       @NotNull BigDecimal precio,

        @NotNull int stok,

        CategoriaProducto categoria
) {
}
