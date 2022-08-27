package com.example.tripapp.service.mapper;

import com.example.tripapp.dto.request.LocationRequestDto;
import com.example.tripapp.dto.response.LocationResponseDto;
import com.example.tripapp.model.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationDtoMapper implements AbstractDtoMapper<LocationResponseDto, Location, LocationRequestDto>{
    @Override
    public Location toModel(LocationRequestDto locationRequestDto) {
        Location location = new Location();
        location.setCity(locationRequestDto.getCity());
        location.setCountry(locationRequestDto.getCountry());
        location.setPlace(locationRequestDto.getPlace());
        return location;
    }

    @Override
    public LocationResponseDto toDto(Location location) {
        LocationResponseDto locationResponseDto = new LocationResponseDto();
        locationResponseDto.setId(location.getId());
        locationResponseDto.setCity(location.getCity());
        locationResponseDto.setCountry(location.getCountry());
        locationResponseDto.setPlace(location.getPlace());
        return locationResponseDto;
    }
}
