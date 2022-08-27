package com.example.tripapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.tripapp.dto.request.TourOperatorRequestDto;
import com.example.tripapp.dto.response.TourOperatorResponseDto;
import com.example.tripapp.service.TourOperatorService;
import com.example.tripapp.service.mapper.TourOperatorDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tour-operators")
public class TourOperatorController {
    private TourOperatorService tourOperatorService;
    private TourOperatorDtoMapper tourOperatorDtoMapper;

    public TourOperatorController(TourOperatorService tourOperatorService, TourOperatorDtoMapper tourOperatorDtoMapper) {
        this.tourOperatorService = tourOperatorService;
        this.tourOperatorDtoMapper = tourOperatorDtoMapper;
    }

    @GetMapping
    List<TourOperatorResponseDto> getAllLocations() {
        return tourOperatorService.getAll().stream()
                .map(tourOperatorDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    TourOperatorResponseDto getById(@PathVariable Long id) {
        return tourOperatorDtoMapper.toDto(tourOperatorService.get(id));
    }

    @PostMapping
    TourOperatorResponseDto create(TourOperatorRequestDto requestDto) {
        return tourOperatorDtoMapper.toDto(tourOperatorService.add(tourOperatorDtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    TourOperatorResponseDto update(@RequestBody TourOperatorRequestDto requestDto, @PathVariable Long id) {
        return tourOperatorDtoMapper.toDto(tourOperatorService.update(tourOperatorDtoMapper.toModel(requestDto), id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        tourOperatorService.delete(id);
    }
}
