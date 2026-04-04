package com.pruebaTecnica.TodoCode.dto.detalleVenta;

import com.pruebaTecnica.TodoCode.model.DetalleVenta;

import java.math.BigDecimal;

public record DetalleVentaDetalladoDTO(
        String producto,
        int cantidad,
        BigDecimal subTotal
) {
    public DetalleVentaDetalladoDTO(DetalleVenta dt){
    this(
            dt.getProducto().getNombre(),
            dt.getCantidad(),
            dt.getSub_total()
    );
    }
}
