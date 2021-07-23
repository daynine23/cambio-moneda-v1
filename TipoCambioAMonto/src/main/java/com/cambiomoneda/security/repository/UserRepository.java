package com.cambiomoneda.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cambiomoneda.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
