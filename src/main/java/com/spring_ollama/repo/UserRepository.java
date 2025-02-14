package com.spring_ollama.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_ollama.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
