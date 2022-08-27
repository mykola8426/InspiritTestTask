package com.example.tripapp.controller;

import com.example.tripapp.dto.request.UserRequestDto;
import com.example.tripapp.dto.response.UserResponseDto;
import com.example.tripapp.model.User;
import com.example.tripapp.service.AuthenticationService;
import com.example.tripapp.service.mapper.UserDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private AuthenticationService service;
    private UserDtoMapper userDtoMapper;

    public AuthenticationController(AuthenticationService service, UserDtoMapper userDtoMapper) {
        this.service = service;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = service.register(requestDto.getName(),
                requestDto.getLastName(), requestDto.getEmail(),
                requestDto.getPassword(), requestDto.getBirthDate());
        return userDtoMapper.toDto(user);
    }
}
