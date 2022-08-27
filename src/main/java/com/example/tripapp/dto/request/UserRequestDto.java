package com.example.tripapp.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserRequestDto {
    private String email;
    private String password;
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
