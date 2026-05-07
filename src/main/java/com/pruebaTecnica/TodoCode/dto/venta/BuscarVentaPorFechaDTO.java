package com.pruebaTecnica.TodoCode.dto.venta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BuscarVentaPorFechaDTO(
       @NotNull LocalDate fecha
) {
}
