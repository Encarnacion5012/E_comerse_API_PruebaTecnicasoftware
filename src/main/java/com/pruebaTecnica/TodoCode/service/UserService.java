package com.pruebaTecnica.TodoCode.service;

import com.pruebaTecnica.TodoCode.dto.user.ActualizarUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.RegistroUsersDTO;
import com.pruebaTecnica.TodoCode.dto.user.UserDetallesDTO;
import com.pruebaTecnica.TodoCode.mapper.UserMapper;
import com.pruebaTecnica.TodoCode.model.user.User;
import com.pruebaTecnica.TodoCode.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements CrudServicesInterface<User,Long, RegistroUsersDTO, ActualizarUsersDTO, UserDetallesDTO> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public User registrar(RegistroUsersDTO datos) {
        var user = new User(datos);
        user.setClave(passwordEncoder.encode(datos.clave()));

        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User actualizar(ActualizarUsersDTO datos, Long id) {
       var user = buscarPorId(id);
       userMapper.actualizarUasuariosDesdeDTO(datos, user);
        return user;
    }

    @Transactional
    @Override
    public void eliminar(Long id) {
        var user = buscarPorId(id);

        user.eliminarUsuario();
    }

    @Override
    public User buscarPorId(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuario no encontrado"));
    }

    @Override
    public Page<UserDetallesDTO> listarTodos(Pageable pageable) {

        return userRepository.findAllByActivoTrue(pageable)
                .map(UserDetallesDTO::new);
    }



}
