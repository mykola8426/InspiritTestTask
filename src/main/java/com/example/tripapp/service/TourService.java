package com.example.tripapp.service;

import com.example.tripapp.model.Location;
import com.example.tripapp.model.Tour;

public interface TourService extends GenericOperationService<Tour> {
    Tour addLocationToTour(Tour tour, Location location);

    Tour deleteLocationFromTour(Tour tour, Location location);
}
