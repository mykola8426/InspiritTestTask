package com.example.tripapp.service.impl;

import java.util.List;
import com.example.tripapp.model.TourOperator;
import com.example.tripapp.repository.TourOperatorRepository;
import com.example.tripapp.service.TourOperatorService;
import org.springframework.stereotype.Service;

@Service
public class TourOperatorServiceImpl implements TourOperatorService {
    private TourOperatorRepository tourOperatorRepository;

    public TourOperatorServiceImpl(TourOperatorRepository tourOperatorRepository) {
        this.tourOperatorRepository = tourOperatorRepository;
    }

    @Override
    public List<TourOperator> getAll() {
        return tourOperatorRepository.findAll();
    }

    @Override
    public TourOperator add(TourOperator tourOperator) {
        return tourOperatorRepository.save(tourOperator);
    }

    @Override
    public TourOperator get(Long id) {
        return tourOperatorRepository.getById(id);
    }

    @Override
    public TourOperator update(TourOperator tourOperator, Long id) {
        tourOperator.setId(id);
        return tourOperatorRepository.save(tourOperator);
    }

    @Override
    public void delete(Long id) {
        tourOperatorRepository.deleteById(id);
    }
}
