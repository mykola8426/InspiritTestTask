package com.example.tripapp.service;

import java.util.Optional;
import com.example.tripapp.model.User;

public interface UserService extends GenericOperationService<User> {

    Optional<User> findByEmail(String email);
}
