package com.pruebaTecnica.TodoCode.mapper;

import com.pruebaTecnica.TodoCode.dto.user.ActualizarUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.RegistroUsersDTO;
import com.pruebaTecnica.TodoCode.model.user.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(componentModel = "spring")

public abstract class UserMapper {
    @Autowired
    protected PasswordEncoder passwordEncoder;




    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "clave", expression = "java(uDTO.clave() != null ? passwordEncoder.encode(uDTO.clave()) : null)")
    public abstract void actualizarUasuariosDesdeDTO(ActualizarUsersDTO uDTO, @MappingTarget User user);


    @Mapping(target = "activo", constant = "true")
    @Mapping(target = "clave", expression = "java(registroUsersDTO.clave() != null ? passwordEncoder.encode(registroUsersDTO.clave()) : null)")
    public abstract User toEntity(RegistroUsersDTO registroUsersDTO);
}
