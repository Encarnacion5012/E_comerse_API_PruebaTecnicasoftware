package com.pruebaTecnica.TodoCode.dto.venta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BuscarVentaPofFechaDTO(
       @NotNull LocalDate fecha
) {
}
