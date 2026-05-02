package com.pruebaTecnica.TodoCode.repository;

import com.pruebaTecnica.TodoCode.model.DetalleVenta;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query("SELECT d.producto AS producto, SUM(d.cantidad) AS cantidadTotal " +
            "FROM DetalleVenta d " +
            "GROUP BY d.producto " +
            "ORDER BY SUM(d.cantidad) DESC")
    List<Tuple> top10Vendidos(Pageable pageable);
}
