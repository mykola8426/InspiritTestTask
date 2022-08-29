package com.example.tripapp.security;

import java.util.NoSuchElementException;
import java.util.Optional;
import javax.transaction.Transactional;
import com.example.tripapp.model.User;
import com.example.tripapp.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findUser = userService.findByEmail(username);
        if (findUser.isPresent()) {
            User user = findUser.get();
            org.springframework.security.core.userdetails.User.UserBuilder  builder =
                    org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            builder.roles(user.getRoles().stream()
                    .map(r -> r.getRoleName().name())
                    .toArray(String[]::new));
            return builder.build();
        }
        throw new NoSuchElementException("Can't find user by email: " + username);
    }
}
