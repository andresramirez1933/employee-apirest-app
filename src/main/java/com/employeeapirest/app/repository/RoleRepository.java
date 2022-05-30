package com.employeeapirest.app.repository;

import com.employeeapirest.app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
