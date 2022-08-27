package com.example.tripapp.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class TourResponseDto {
    private Long id;
    private String name;
    private List<Long> locationIds;
    private String tourType;
    private Long tourOperatorId;
}
