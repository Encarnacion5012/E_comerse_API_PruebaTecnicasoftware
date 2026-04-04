package com.pruebaTecnica.TodoCode.dto.user;

import com.pruebaTecnica.TodoCode.model.user.Rol_User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistroUsersDTO(
      @NotBlank String nombre,
      @Email String email,
      @NotBlank  String clave,
        Rol_User rol

) {
}
