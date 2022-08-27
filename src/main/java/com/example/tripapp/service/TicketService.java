package com.example.tripapp.service;

import java.math.BigDecimal;
import java.util.List;
import com.example.tripapp.model.Ticket;

public interface TicketService extends GenericOperationService<Ticket> {
    List<Ticket> findAllByPriceBetween(BigDecimal from, BigDecimal to);
}
