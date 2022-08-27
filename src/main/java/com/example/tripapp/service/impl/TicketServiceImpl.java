package com.example.tripapp.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.example.tripapp.model.Ticket;
import com.example.tripapp.repository.TicketRepository;
import com.example.tripapp.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket add(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket get(Long id) {
        return ticketRepository.getById(id);
    }

    @Override
    public Ticket update(Ticket ticket, Long id) {
        ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findAllByPriceBetween(BigDecimal from, BigDecimal to) {
        return ticketRepository.findAllByPriceBetween(from, to);
    }
}
