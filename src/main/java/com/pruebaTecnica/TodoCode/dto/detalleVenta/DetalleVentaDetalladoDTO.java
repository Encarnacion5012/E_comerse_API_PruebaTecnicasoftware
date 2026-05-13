package com.pruebaTecnica.TodoCode.dto.detalleVenta;

import com.pruebaTecnica.TodoCode.model.DetalleVenta;

import java.math.BigDecimal;

public record DetalleVentaDetalladoDTO(
        String producto,
        int cantidad,
        BigDecimal sub_total
) {

}
