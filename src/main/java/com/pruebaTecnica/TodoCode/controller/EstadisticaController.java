package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.estadistica.TopDTO;
import com.pruebaTecnica.TodoCode.mapper.EstadisticaMapper;
import com.pruebaTecnica.TodoCode.service.EstadisticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/estadistica")
@RequiredArgsConstructor
public class EstadisticaController {

    private final EstadisticasService estadisticasService;
    private final EstadisticaMapper estadisticaMapper;

    @GetMapping("/masVendidos_top-{numero}")
    ResponseEntity top10MasVendido(@PathVariable int numero){
        var productos = estadisticasService.topVendidos(numero);

        return ResponseEntity.ok().body(estadisticaMapper.topToDtoList(productos));
    }
}
