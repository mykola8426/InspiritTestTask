package com.example.tripapp.dto.request;

import lombok.Data;

@Data
public class LocationRequestDto {
    private String city;
    private String country;
    private String place;
}
