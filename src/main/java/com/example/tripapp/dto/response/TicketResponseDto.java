package com.example.tripapp.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class TicketResponseDto {
    private Long id;
    private Long tourId;
    private BigDecimal price;
    private LocalDate tourDate;
}
