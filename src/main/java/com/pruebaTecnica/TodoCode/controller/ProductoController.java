package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.producto.ActualizarProductoDTO;
import com.pruebaTecnica.TodoCode.dto.producto.DetallePrductoDTO;
import com.pruebaTecnica.TodoCode.dto.producto.RegistarProductoDTO;
import com.pruebaTecnica.TodoCode.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping("/register")
    public ResponseEntity crearProducto(@RequestBody @Valid RegistarProductoDTO dto, UriComponentsBuilder uriComponentsBuilder){
        var producto = productoService.registrar(dto);
        var uri = uriComponentsBuilder.path("/producto/register/{id}").buildAndExpand(producto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetallePrductoDTO(producto));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizarProducto(@RequestBody ActualizarProductoDTO dto, @PathVariable long id){
        var producto = productoService.actualizar(dto, id);
        return ResponseEntity.ok(new DetallePrductoDTO(producto));
    }

    @GetMapping("/buscar_Id/{id}")
    public ResponseEntity buscarPorId(@PathVariable long id){
        var producto = productoService.buscarPorId(id);

        return ResponseEntity.ok(new DetallePrductoDTO(producto));
    }

    @GetMapping("/lisar")
    public ResponseEntity listarTodos(@PageableDefault(size = 10, sort = {"nombre"})Pageable pageable){
        var productos = productoService.listarTodos(pageable)
                .map(DetallePrductoDTO::new).toList();

        return ResponseEntity.ok(productos);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarProducto(@PathVariable long id){
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
