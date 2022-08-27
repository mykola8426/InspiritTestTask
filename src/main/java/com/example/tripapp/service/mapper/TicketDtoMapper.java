package com.example.tripapp.service.mapper;

import com.example.tripapp.dto.request.TicketRequestDto;
import com.example.tripapp.dto.response.TicketResponseDto;
import com.example.tripapp.model.Ticket;
import com.example.tripapp.service.TourService;
import org.springframework.stereotype.Component;

@Component
public class TicketDtoMapper implements AbstractDtoMapper<TicketResponseDto, Ticket, TicketRequestDto> {
    private TourService tourService;

    public TicketDtoMapper(TourService tourService) {
        this.tourService = tourService;
    }

    @Override
    public Ticket toModel(TicketRequestDto ticketRequestDto) {
        Ticket ticket = new Ticket();
        ticket.setPrice(ticketRequestDto.getPrice());
        ticket.setTourDate(ticketRequestDto.getTourDate());
        ticket.setTour(tourService.get(ticketRequestDto.getTourId()));
        return ticket;
    }

    @Override
    public TicketResponseDto toDto(Ticket ticket) {
        TicketResponseDto responseDto = new TicketResponseDto();
        responseDto.setId(ticket.getId());
        responseDto.setPrice(ticket.getPrice());
        responseDto.setTourDate(ticket.getTourDate());
        responseDto.setTourId(ticket.getTour().getId());
        return responseDto;
    }
}
