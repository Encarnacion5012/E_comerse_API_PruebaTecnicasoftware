package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.venta.BuscarVentaPorFechaDTO;
import com.pruebaTecnica.TodoCode.dto.venta.RegistrarVentaDTO;
import com.pruebaTecnica.TodoCode.dto.venta.VentaDetalladaDTO;
import com.pruebaTecnica.TodoCode.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/listar")
    ResponseEntity<Page<VentaDetalladaDTO>> listarTodasLasVentas(@PageableDefault(size = 10, sort = {"total"}) Pageable pageable){
        var ventas = ventaService.listarVentas(pageable);



        return ResponseEntity.ok().body(ventas);
    }

    @GetMapping("/bucar_por_fecha")
    public ResponseEntity  ventasPorFechas(@RequestBody BuscarVentaPorFechaDTO fechaDTO){
        var ventas = ventaService.listarVentasEnUnaCiertaFecha(fechaDTO.fecha()).stream()
                .map(VentaDetalladaDTO::new)
                .toList();

        return ResponseEntity.ok(ventas);
    }




}
