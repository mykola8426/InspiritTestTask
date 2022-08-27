package com.example.tripapp.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private LocalDate birthDate;
}
