package com.example.tripapp.repository;

import java.util.List;
import com.example.tripapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByCountry(String country);
}
