package com.pruebaTecnica.TodoCode.dto.sucursal;

import jakarta.validation.constraints.NotBlank;

public record RegistroSucursalDTO(
        @NotBlank String nombre,

        @NotBlank String direccion

) {
}
