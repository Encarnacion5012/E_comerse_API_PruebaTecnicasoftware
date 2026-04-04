package com.pruebaTecnica.TodoCode.infra.security.tokenJWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.pruebaTecnica.TodoCode.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service

public class TokenService {
 @Value("${app.security.jwt-secret}")
    private String secretKey;

 private final String ISSUER = "Prueba_Todocode";

 public String generarToken(User user){
     var algoritmo = Algorithm.HMAC256(secretKey);

     try {
         return JWT.create()
                 .withIssuer(ISSUER)
                 .withSubject(user.getEmail())
                 .withExpiresAt(Instant.now().plus(2, ChronoUnit.HOURS))
                 .sign(algoritmo);

     } catch (JWTCreationException e) {
         throw new RuntimeException("Error al crear Token");
     }
 }

 public String getUser(String tokenJWT){
     var algoritmo = Algorithm.HMAC256(secretKey);
     try {
          return JWT.require(algoritmo)
                 .withIssuer(ISSUER)
                 .build().verify(tokenJWT)
                 .getSubject();

     } catch (JWTDecodeException e) {
         throw new RuntimeException("Token invalido o expirado");
     }
 }
}
