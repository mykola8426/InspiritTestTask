package com.example.tripapp.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import com.example.tripapp.dto.request.TicketRequestDto;
import com.example.tripapp.dto.response.TicketResponseDto;
import com.example.tripapp.service.TicketService;
import com.example.tripapp.service.mapper.TicketDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;
    private TicketDtoMapper ticketDtoMapper;

    public TicketController(TicketService ticketService, TicketDtoMapper ticketDtoMapper) {
        this.ticketService = ticketService;
        this.ticketDtoMapper = ticketDtoMapper;
    }

    @GetMapping
    public List<TicketResponseDto> getAll() {
        return ticketService.getAll().stream()
                .map(ticketDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TicketResponseDto getById(@PathVariable Long id) {
        return ticketDtoMapper.toDto(ticketService.get(id));
    }

    @PostMapping
    public TicketResponseDto create(@RequestBody TicketRequestDto requestDto) {
        return ticketDtoMapper.toDto(ticketService.add(ticketDtoMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    public TicketResponseDto update(@RequestBody TicketRequestDto requestDto, @PathVariable Long id) {
        return ticketDtoMapper.toDto(ticketService.update(ticketDtoMapper.toModel(requestDto), id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

    @GetMapping("/by-price")
    List<TicketResponseDto> findAllByPriceBetween(@RequestParam BigDecimal from,
                                                  @RequestParam BigDecimal to) {
        return ticketService.findAllByPriceBetween(from, to).stream()
                .map(ticketDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
