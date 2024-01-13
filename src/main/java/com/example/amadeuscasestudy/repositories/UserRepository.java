package com.example.amadeuscasestudy.repositories;

import com.example.amadeuscasestudy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailEqualsAndPasswordEquals(String email, String password);
    Optional<User> findByEmailEqualsIgnoreCase(String email);


}