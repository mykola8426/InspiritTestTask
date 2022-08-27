package com.example.tripapp.service.impl;

import java.util.List;
import com.example.tripapp.model.Location;
import com.example.tripapp.model.Tour;
import com.example.tripapp.repository.TourRepository;
import com.example.tripapp.service.TourService;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {
    private TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    @Override
    public Tour add(Tour tour) {
        return tourRepository.save(tour);
    }

    @Override
    public Tour get(Long id) {
        return tourRepository.getById(id);
    }

    @Override
    public Tour update(Tour tour, Long id) {
        tour.setId(id);
        return tourRepository.save(tour);
    }

    @Override
    public void delete(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public Tour addLocationToTour(Tour tour, Location location) {
        tour.getLocations().add(location);
        return tourRepository.save(tour);
    }

    @Override
    public Tour deleteLocationFromTour(Tour tour, Location location) {
        tour.getLocations().remove(location);
        return tourRepository.save(tour);
    }
}
