package com.pruebaTecnica.TodoCode.mapper;

import com.pruebaTecnica.TodoCode.dto.estadistica.Producto_Para_TopDTO;
import com.pruebaTecnica.TodoCode.dto.estadistica.Producto_Top_Precyection;
import com.pruebaTecnica.TodoCode.model.producto.Producto;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadisticaMapper {

//    default List<Producto_Para_TopDTO> topToDtoList(Map<Producto, Long> producto_Cantidad){
//        if (producto_Cantidad == null) {
//            return null;
//        }
//
//        return producto_Cantidad.entrySet().stream()
//                .map(this::entryToPDto)
//                .toList();
//
//    }


    @Mapping(source = "producto.nombre", target = "nombre_Producto")
    @Mapping(source = "producto.precio", target = "precio")
    @Mapping(source = "producto.categoria", target = "categoriaProducto")
    @Mapping(source = "cantidadTotal", target = "cantidad_Vendida")
    Producto_Para_TopDTO TopProyeccionToDto(Producto_Top_Precyection producto_Cantidad);

    List<Producto_Para_TopDTO>proyeccionToListDto(List<Producto_Top_Precyection> producto_Cantidad);
}
