package com.example.tripapp.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.PostConstruct;
import com.example.tripapp.model.Role;
import com.example.tripapp.model.User;
import com.example.tripapp.service.RoleService;
import com.example.tripapp.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private UserService userService;
    private RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role user = new Role();
        user.setRoleName(Role.RoleName.USER);
        roleService.add(user);

        Role admin = new Role();
        admin.setRoleName(Role.RoleName.ADMIN);
        roleService.add(admin);

        User bohdan = new User();
        bohdan.setName("Bohdan");
        bohdan.setLastName("Romaniv");
        bohdan.setEmail("bohdanRomaniv@gmail.com");
        bohdan.setPassword("12345");
        bohdan.setTickets(new ArrayList<>());
        bohdan.setRoles(Set.of(admin));
        bohdan.setBirthDate(LocalDate.of(2000, Month.JULY, 22));
        userService.add(bohdan);

        User mykola = new User();
        mykola.setName("Mykola");
        mykola.setLastName("Yakymiv");
        mykola.setEmail("mykoolayakymiv@gmail.com");
        mykola.setPassword("12345");
        mykola.setTickets(new ArrayList<>());
        mykola.setRoles(Set.of(user));
        mykola.setBirthDate(LocalDate.of(2000, Month.JULY, 22));
        userService.add(mykola);
    }
}
