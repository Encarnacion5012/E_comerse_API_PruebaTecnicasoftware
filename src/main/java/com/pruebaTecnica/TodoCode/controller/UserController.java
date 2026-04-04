package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.user.ActualizarUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.RegistroUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.UserDetallesDTO;
import com.pruebaTecnica.TodoCode.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity crearUsuario(@RequestBody @Valid RegistroUsersDTO usersDTO, UriComponentsBuilder uriComponentsBuilder){
        var user = userService.registrar(usersDTO);
        var uri = uriComponentsBuilder.path("/users/register/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetallesDTO(user));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity actualizarUsuario(@RequestBody ActualizarUsersDTO datos, @PathVariable long id){
        var user = userService.actualizar(datos,id);
        return ResponseEntity.ok().body(new UserDetallesDTO(user));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable long id){
        userService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity buscarPorID(@PathVariable long id){
        var user = userService.buscarPorId(id);

       return ResponseEntity.ok().body(new UserDetallesDTO(user));
    }

    @GetMapping("/listar")
    public ResponseEntity listarUsuarios(@PageableDefault(size = 10, sort = {"nombre"})Pageable paginacion){
        var usuarios = userService.listarTodos(paginacion)
                .map(UserDetallesDTO::new).toList();

        return ResponseEntity.ok().body(usuarios);
    }
}
