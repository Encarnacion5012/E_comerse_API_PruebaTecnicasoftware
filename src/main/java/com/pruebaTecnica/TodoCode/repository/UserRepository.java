package com.pruebaTecnica.TodoCode.repository;

import com.pruebaTecnica.TodoCode.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);


    Page<User> findAllByActivoTrue(Pageable pageable);
}
