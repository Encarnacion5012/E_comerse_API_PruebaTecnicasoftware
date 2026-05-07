package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.sucursal.DetalleSucursalDTO;
import com.pruebaTecnica.TodoCode.dto.sucursal.RegistroSucursalDTO;
import com.pruebaTecnica.TodoCode.mapper.SucursalMapper;
import com.pruebaTecnica.TodoCode.service.SucursalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sucursales")
@RequiredArgsConstructor
public class SucursalController {
    private final SucursalService sucursalService;
    private final SucursalMapper sucursalMapper;

    @PostMapping("/registrar")
    public ResponseEntity registarSucursales(@RequestBody @Valid RegistroSucursalDTO dto, UriComponentsBuilder uriComponentsBuilder){
        var sucursal = sucursalService.registar(dto);
        var uri = uriComponentsBuilder.path("/sucursales/registrar/{id}").buildAndExpand(sucursal.getId()).toUri();

        return ResponseEntity.created(uri).body(sucursalMapper.toDto(sucursal));
    }
}
