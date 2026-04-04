package com.pruebaTecnica.TodoCode.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @Email String email,
        @NotBlank String clave
) {
}
