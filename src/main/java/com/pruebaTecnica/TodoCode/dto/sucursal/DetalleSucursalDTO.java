package com.pruebaTecnica.TodoCode.dto.sucursal;

import com.pruebaTecnica.TodoCode.model.Sucursal;
import jakarta.validation.constraints.NotBlank;

public record DetalleSucursalDTO(
        long id,

        String nombre,

        String direccion

) {
    public DetalleSucursalDTO(Sucursal s){
        this(
                s.getId(),
                s.getNombre(),
                s.getDireccion()
        );
    }
}
