package com.example.tripapp.service.mapper;

import java.util.stream.Collectors;
import com.example.tripapp.dto.request.TourRequestDto;
import com.example.tripapp.dto.response.TourResponseDto;
import com.example.tripapp.model.Location;
import com.example.tripapp.model.Tour;
import com.example.tripapp.service.LocationService;
import com.example.tripapp.service.TourOperatorService;
import org.springframework.stereotype.Component;

@Component
public class TourDtoMapper implements AbstractDtoMapper<TourResponseDto, Tour, TourRequestDto>{
    private LocationService locationService;
    private TourOperatorService tourOperatorService;

    public TourDtoMapper(LocationService locationService, TourOperatorService tourOperatorService) {
        this.locationService = locationService;
        this.tourOperatorService = tourOperatorService;
    }

    @Override
    public Tour toModel(TourRequestDto tourRequestDto) {
        Tour tour = new Tour();
        tour.setName(tourRequestDto.getName());
        tour.setTourType(tourRequestDto.getTourType());
        tour.setTourOperator(tourOperatorService.get(tourRequestDto.getTourOperatorId()));
        tour.setLocations(tourRequestDto.getLocationIds().stream()
                .map(i -> locationService.get(i))
                .collect(Collectors.toList()));

        return tour;
    }

    @Override
    public TourResponseDto toDto(Tour tour) {
        TourResponseDto tourResponseDto = new TourResponseDto();
        tourResponseDto.setId(tour.getId());
        tourResponseDto.setName(tour.getName());
        tourResponseDto.setTourType(tour.getTourType());
        tourResponseDto.setTourOperatorId(tour.getTourOperator().getId());
        tourResponseDto.setLocationIds(tour.getLocations().stream()
                .map(Location::getId)
                .collect(Collectors.toList()));
        return tourResponseDto;
    }
}
