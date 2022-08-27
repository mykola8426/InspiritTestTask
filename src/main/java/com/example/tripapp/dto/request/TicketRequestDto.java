package com.example.tripapp.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class TicketRequestDto {
    private Long tourId;
    private BigDecimal price;
    private LocalDate tourDate;
}
