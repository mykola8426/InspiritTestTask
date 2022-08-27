package com.example.tripapp.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
import com.example.tripapp.model.Role;
import com.example.tripapp.model.User;
import com.example.tripapp.service.AuthenticationService;
import com.example.tripapp.service.RoleService;
import com.example.tripapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    private RoleService roleService;

    public AuthenticationServiceImpl(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String name, String lastname, String email, String password, LocalDate birthDate) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastname);
        user.setPassword(password);
        user.setEmail(email);
        user.setBirthDate(birthDate);
        user.setTickets(new ArrayList<>());
        user.setRoles(Set.of(roleService.getByName(Role.RoleName.USER.name())));
        return userService.add(user);
    }
}
