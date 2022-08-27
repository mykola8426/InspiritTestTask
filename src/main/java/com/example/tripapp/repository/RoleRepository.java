package com.example.tripapp.repository;

import com.example.tripapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleNameEquals(Role.RoleName roleName);
}
