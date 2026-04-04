package com.pruebaTecnica.TodoCode.service;

import com.pruebaTecnica.TodoCode.dto.sucursal.RegistroSucursalDTO;
import com.pruebaTecnica.TodoCode.mapper.SucursalMapper;
import com.pruebaTecnica.TodoCode.model.Sucursal;
import com.pruebaTecnica.TodoCode.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SucursalService {
    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    public Sucursal registar(RegistroSucursalDTO dto){
        var sucursal = sucursalMapper.toEntity(dto);
        return sucursalRepository.save(sucursal);
    }
}
