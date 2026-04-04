package com.pruebaTecnica.TodoCode.dto.venta;

import com.pruebaTecnica.TodoCode.dto.detalleVenta.RegistroDetalleVentaDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RegistrarVentaDTO(
        @NotNull Long id_sucursal,
        @Valid List<RegistroDetalleVentaDTO> detalle_Venta
        ) {
}
