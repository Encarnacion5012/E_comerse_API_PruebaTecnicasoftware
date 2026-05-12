package com.pruebaTecnica.TodoCode.service;

import com.pruebaTecnica.TodoCode.dto.producto.ActualizarProductoDTO;
import com.pruebaTecnica.TodoCode.dto.producto.DetallePrductoDTO;
import com.pruebaTecnica.TodoCode.dto.producto.RegistarProductoDTO;
import com.pruebaTecnica.TodoCode.mapper.ProductoMapper;
import com.pruebaTecnica.TodoCode.model.producto.CategoriaProducto;
import com.pruebaTecnica.TodoCode.model.producto.Producto;
import com.pruebaTecnica.TodoCode.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService implements CrudServicesInterface<Producto, Long, RegistarProductoDTO, ActualizarProductoDTO, DetallePrductoDTO>{
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;


    @Transactional
    @Override
    public Producto registrar(RegistarProductoDTO datos) {
        var producto = productoMapper.toEntity(datos);
        return productoRepository.save(producto);
    }

    @Transactional
    @Override
    public Producto actualizar(ActualizarProductoDTO datos, Long id) {
        var producto = buscarPorId(id);
        productoMapper.ActualizarProductoDesdeDTO(datos, producto);

        return producto;
    }

    @Override
    public void eliminar(Long id) {
        var producto = buscarPorId(id);
        producto.eliminar();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Producto no encontrado"));
    }

    @Override
    public Page<DetallePrductoDTO> listarTodos(Pageable pageable) {
        return productoRepository.findAllByActivoTrue(pageable)
                .map(productoMapper::toDtoDetalleP);
    }

    public Page<DetallePrductoDTO> buscarProductosPorCategoria(CategoriaProducto categoria, Pageable pageable){
        return productoRepository.findByCategoriaAndActivoTrue(categoria, pageable)
                .map(productoMapper::toDtoDetalleP);

    }


}
