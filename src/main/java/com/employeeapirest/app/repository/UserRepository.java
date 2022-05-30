package com.employeeapirest.app.repository;

import com.employeeapirest.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailOrUsername(String username, String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
