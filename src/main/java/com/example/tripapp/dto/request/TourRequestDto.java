package com.example.tripapp.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class TourRequestDto {
    private String name;
    private List<Long> locationIds;
    private String tourType;
    private Long tourOperatorId;
}
