package com.example.tripapp.service;

import java.util.List;
import com.example.tripapp.model.Location;

public interface LocationService extends GenericOperationService<Location> {
    List<Location> findAllByCountry(String country);
}
