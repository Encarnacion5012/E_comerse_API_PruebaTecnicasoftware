package com.pruebaTecnica.TodoCode.dto.venta;

import com.pruebaTecnica.TodoCode.dto.detalleVenta.DetalleVentaDetalladoDTO;
import com.pruebaTecnica.TodoCode.model.Venta;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VentaDetalladaDTO(
        long id,
        String sucursal,
        LocalDateTime fecha_venta,
        List<DetalleVentaDetalladoDTO> detalleVentas,
        BigDecimal total
) {
//    public VentaDetalladaDTO(Venta v){
//        this(
//                v.getId(),
//                v.getSucursal().getNombre(),
//                v.getFecha_venta(),
//                v.getDetalleVentas().stream().map(DetalleVentaDetalladoDTO::new).toList(),
//                v.getTotal()
//        );
//    }
}
