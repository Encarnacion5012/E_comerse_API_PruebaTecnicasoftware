package com.pruebaTecnica.TodoCode.mapper;

import com.pruebaTecnica.TodoCode.dto.producto.ActualizarProductoDTO;
import com.pruebaTecnica.TodoCode.dto.producto.RegistarProductoDTO;
import com.pruebaTecnica.TodoCode.model.producto.Producto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mapping(target = "activo", constant = "true")
    Producto toEntity(RegistarProductoDTO pDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void ActualizarProductoDesdeDTO(ActualizarProductoDTO dto, @MappingTarget Producto producto);

}
