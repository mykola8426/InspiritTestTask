package com.example.tripapp.service;

import java.time.LocalDate;
import com.example.tripapp.model.User;

public interface AuthenticationService {
    User register(String name, String lastname, String email, String password, LocalDate birthDate);
}
