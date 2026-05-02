package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.estadistica.Top_10;
import com.pruebaTecnica.TodoCode.service.EstadisticasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/estadistica")
@RequiredArgsConstructor
public class EstadisticaController {

    private final EstadisticasService estadisticasService;

    @GetMapping("/top_10-masVendidos")
    ResponseEntity top10MasVendido(){
        var productos = new LinkedHashMap<>(estadisticasService.topVendidos(10));

        return ResponseEntity.ok(new Top_10(productos));
    }
}
