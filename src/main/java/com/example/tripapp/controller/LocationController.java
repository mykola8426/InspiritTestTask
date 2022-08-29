package com.example.tripapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.tripapp.dto.request.LocationRequestDto;
import com.example.tripapp.dto.response.LocationResponseDto;
import com.example.tripapp.service.LocationService;
import com.example.tripapp.service.mapper.LocationDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private LocationService locationService;
    private LocationDtoMapper locationDtoMapper;

    public LocationController(LocationService locationService, LocationDtoMapper locationDtoMapper) {
        this.locationService = locationService;
        this.locationDtoMapper = locationDtoMapper;
    }

    @GetMapping
    public List<LocationResponseDto> getAllLocations() {
        return locationService.getAll().stream()
                .map(locationDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LocationResponseDto getById(@PathVariable Long id) {
        return locationDtoMapper.toDto(locationService.get(id));
    }

    @PostMapping
    public LocationResponseDto create(@RequestBody LocationRequestDto requestDto) {
        return locationDtoMapper.toDto(locationService.add(locationDtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public LocationResponseDto update(@RequestBody LocationRequestDto requestDto, @PathVariable Long id) {
        return locationDtoMapper.toDto(locationService.update(locationDtoMapper.toModel(requestDto), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        locationService.delete(id);
    }

    @GetMapping("/by-country")
    public List<LocationResponseDto> findAllByCountry(@RequestParam String country) {
        return locationService.findAllByCountry(country).stream()
                .map(locationDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
