package com.example.tripapp.service;

import com.example.tripapp.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String name);
}
