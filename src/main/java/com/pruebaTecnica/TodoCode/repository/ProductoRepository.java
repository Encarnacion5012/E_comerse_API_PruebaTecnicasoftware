package com.pruebaTecnica.TodoCode.repository;

import com.pruebaTecnica.TodoCode.model.producto.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Page<Producto>findAllByActivoTrue(Pageable pageable);
}
