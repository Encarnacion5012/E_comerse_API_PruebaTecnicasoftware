package com.pruebaTecnica.TodoCode.dto.detalleVenta;

import jakarta.validation.constraints.NotNull;

public record RegistroDetalleVentaDTO(
        @NotNull Long id_Producto,
        @NotNull int cantidad

        )
{}
