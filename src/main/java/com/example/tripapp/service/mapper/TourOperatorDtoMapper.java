package com.example.tripapp.service.mapper;

import com.example.tripapp.dto.request.TourOperatorRequestDto;
import com.example.tripapp.dto.response.TourOperatorResponseDto;
import com.example.tripapp.model.TourOperator;
import org.springframework.stereotype.Component;

@Component
public class TourOperatorDtoMapper implements AbstractDtoMapper<TourOperatorResponseDto, TourOperator, TourOperatorRequestDto>{
    @Override
    public TourOperator toModel(TourOperatorRequestDto tourOperatorRequestDto) {
        TourOperator tourOperator = new TourOperator();
        tourOperator.setName(tourOperatorRequestDto.getName());
        return tourOperator;
    }

    @Override
    public TourOperatorResponseDto toDto(TourOperator tourOperator) {
        TourOperatorResponseDto responseDto = new TourOperatorResponseDto();
        responseDto.setId(tourOperator.getId());
        responseDto.setName(tourOperator.getName());
        return responseDto;
    }
}
