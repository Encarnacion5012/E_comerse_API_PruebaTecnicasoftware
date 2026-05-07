package com.pruebaTecnica.TodoCode.mapper;

import com.pruebaTecnica.TodoCode.dto.detalleVenta.DetalleVentaDetalladoDTO;
import com.pruebaTecnica.TodoCode.dto.venta.VentaDetalladaDTO;
import com.pruebaTecnica.TodoCode.model.DetalleVenta;
import com.pruebaTecnica.TodoCode.model.Venta;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VentaMapper {
    @Mapping(source = "venta.sucursal.nombre", target = "sucursal")
    VentaDetalladaDTO toDto(Venta venta);


    @Mapping(source = "producto.nombre", target = "producto")
    DetalleVentaDetalladoDTO detallesToDto(DetalleVenta detalleVenta);
}
