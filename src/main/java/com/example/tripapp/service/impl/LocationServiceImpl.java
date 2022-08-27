package com.example.tripapp.service.impl;

import java.util.List;
import com.example.tripapp.model.Location;
import com.example.tripapp.repository.LocationRepository;
import com.example.tripapp.service.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location add(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location get(Long id) {
        return locationRepository.getById(id);
    }

    @Override
    public Location update(Location location, Long id) {
        location.setId(id);
        return locationRepository.save(location);
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public List<Location> findAllByCountry(String country) {
        return locationRepository.findAllByCountry(country);
    }
}
