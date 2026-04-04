package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.venta.RegistrarVentaDTO;
import com.pruebaTecnica.TodoCode.dto.venta.VentaDetalladaDTO;
import com.pruebaTecnica.TodoCode.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService ventaService;

    @PostMapping("/registar")
    public ResponseEntity registrarVenta(@RequestBody @Valid RegistrarVentaDTO dto, UriComponentsBuilder uriComponentsBuilder ){
       var venta = ventaService.registrarVenta(dto);
        var uri = uriComponentsBuilder.path("/ventas/registrar/{id}").buildAndExpand(venta.getId()).toUri();
        return ResponseEntity.created(uri).body(new VentaDetalladaDTO(venta));
    }
}
