package com.pruebaTecnica.TodoCode.service;

import com.pruebaTecnica.TodoCode.model.producto.Producto;
import com.pruebaTecnica.TodoCode.repository.DetalleVentaRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstadisticasService {
    private final DetalleVentaRepository detalleVentaRepository;

    public Map<Producto, Integer> topVendidos(int limiteTop){
        Pageable pageable = PageRequest.of(0, limiteTop);

        List<Tuple> productosTop = detalleVentaRepository.top10Vendidos(pageable);

        return productosTop.stream()
                .collect(Collectors.toMap(
                        tuple -> tuple.get("producto", Producto.class),
                        tuple -> tuple.get("cantidadTotal", Integer.class),
                        (cantidad1, cantidad2) -> cantidad1,
                        LinkedHashMap::new
                ));
    }
}
