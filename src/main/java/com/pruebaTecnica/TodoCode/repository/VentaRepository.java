package com.pruebaTecnica.TodoCode.repository;

import com.pruebaTecnica.TodoCode.model.Venta;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    Page<Venta>findAll(@NonNull Pageable pageable);

    @Query("Select v FROM Venta v WHERE FUNCTION('DATE', v.fecha_venta) <= :fecha_Limite")
    List<Venta>listarVentasHastaCiertaFecha(LocalDate fecha_Limite);
}
