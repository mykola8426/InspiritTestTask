package com.example.tripapp.dto.response;

import lombok.Data;

@Data
public class LocationResponseDto {
    private Long id;
    private String city;
    private String country;
    private String place;
}
