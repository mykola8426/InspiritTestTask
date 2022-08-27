package com.example.tripapp.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.tripapp.dto.request.TourRequestDto;
import com.example.tripapp.dto.response.TourResponseDto;
import com.example.tripapp.service.TourService;
import com.example.tripapp.service.mapper.TourDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tours")
public class TourController {
    private TourService tourService;
    private TourDtoMapper tourDtoMapper;

    public TourController(TourService tourService, TourDtoMapper tourDtoMapper) {
        this.tourService = tourService;
        this.tourDtoMapper = tourDtoMapper;
    }

    @GetMapping
    public List<TourResponseDto> getAll() {
        return tourService.getAll().stream()
                .map(tourDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TourResponseDto getById(@PathVariable Long id) {
        return tourDtoMapper.toDto(tourService.get(id));
    }

    @PostMapping
    public TourResponseDto create(@RequestBody TourRequestDto requestDto) {
        return tourDtoMapper.toDto(tourService.add(tourDtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public TourResponseDto update(@RequestBody TourRequestDto requestDto, @PathVariable Long id) {
        return tourDtoMapper.toDto(tourService.update(tourDtoMapper.toModel(requestDto), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tourService.delete(id);
    }
}
