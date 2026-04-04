package com.pruebaTecnica.TodoCode.dto.user;

import com.pruebaTecnica.TodoCode.model.user.Rol_User;
import com.pruebaTecnica.TodoCode.model.user.User;

public record UserDetallesDTO(
        long id,
        String nombre,
        String email,
        Rol_User rol
) {
    public UserDetallesDTO(User u){
        this(
                u.getId(),
                u.getNombre(),
                u.getEmail(),
                u.getRol()
        );
    }
}
