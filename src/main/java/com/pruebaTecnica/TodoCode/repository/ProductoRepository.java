package com.pruebaTecnica.TodoCode.repository;

import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import com.pruebaTecnica.TodoCode.model.producto.Producto;
import jakarta.persistence.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Page<Producto>findAllByActivoTrue(Pageable pageable);

    Page<Producto>findByCategoriaAndActivoTrue(CategoriaProducto categoria, Pageable pageable);





}
