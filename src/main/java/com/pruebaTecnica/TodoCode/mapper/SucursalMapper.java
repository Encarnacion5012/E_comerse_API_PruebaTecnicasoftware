package com.pruebaTecnica.TodoCode.mapper;

import com.pruebaTecnica.TodoCode.dto.producto.RegistarProductoDTO;
import com.pruebaTecnica.TodoCode.dto.sucursal.RegistroSucursalDTO;
import com.pruebaTecnica.TodoCode.model.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SucursalMapper {
    Sucursal toEntity(RegistroSucursalDTO dto);
}
