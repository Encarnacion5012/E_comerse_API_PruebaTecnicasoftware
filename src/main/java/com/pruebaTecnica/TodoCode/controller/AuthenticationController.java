package com.pruebaTecnica.TodoCode.controller;

import com.pruebaTecnica.TodoCode.dto.authentication.AuthenticationDTO;
import com.pruebaTecnica.TodoCode.infra.security.tokenJWT.TokemJWTDTO;
import com.pruebaTecnica.TodoCode.infra.security.tokenJWT.TokenService;
import com.pruebaTecnica.TodoCode.model.user.User;
import com.pruebaTecnica.TodoCode.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {
    private final TokenService tokenService;
    private final AuthenticationManager auManager;

    @PostMapping()
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO datos){
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.clave());
        var authentication = auManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(new TokemJWTDTO(tokenJWT));
    }
}
