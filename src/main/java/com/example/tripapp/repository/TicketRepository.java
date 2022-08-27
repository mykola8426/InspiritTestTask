package com.example.tripapp.repository;

import java.math.BigDecimal;
import java.util.List;
import com.example.tripapp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findAllByPriceBetween(BigDecimal from, BigDecimal to);
}
