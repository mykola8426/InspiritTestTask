package com.example.tripapp.service.impl;

import com.example.tripapp.model.Role;
import com.example.tripapp.repository.RoleRepository;
import com.example.tripapp.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.getRoleByRoleNameEquals(Role.RoleName.valueOf(name));
    }
}
