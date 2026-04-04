package com.pruebaTecnica.TodoCode.model.user;

import com.pruebaTecnica.TodoCode.dto.user.ActualizarUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.RegistroUsersDTO;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "users")
public class User implements UserDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String nombre;
private String email;
private String clave;

@Enumerated(EnumType.STRING)
private Rol_User rol;

private boolean activo;

public void eliminarUsuario(){
    this.activo = false;
}

public User(RegistroUsersDTO uDTO){
    this.nombre = uDTO.nombre();
    this.email = uDTO.email();
    this.rol = uDTO.rol();
    this.activo = true;
}



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+rol.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return this.clave;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
