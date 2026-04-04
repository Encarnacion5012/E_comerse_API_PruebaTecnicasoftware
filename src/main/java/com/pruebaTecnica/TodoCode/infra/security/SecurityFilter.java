package com.pruebaTecnica.TodoCode.infra.security;

import com.pruebaTecnica.TodoCode.infra.security.tokenJWT.TokenService;
import com.pruebaTecnica.TodoCode.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = optener_Token(request);
        System.out.println("Token jwt: " + tokenJWT);

        if (tokenJWT!= null){
            var subject = tokenService.getUser(tokenJWT);
            System.out.println("subject: " + subject);
            if (subject != null){
               var user = userRepository.findByEmail(subject);
               var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String optener_Token(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null){
            return authHeader.replace("Bearer ", "");
        }
        else
        {
            return null;
        }
    }
}
