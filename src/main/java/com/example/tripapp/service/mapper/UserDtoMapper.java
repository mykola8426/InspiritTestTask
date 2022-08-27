package com.example.tripapp.service.mapper;

import com.example.tripapp.dto.response.UserResponseDto;
import com.example.tripapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setId(user.getId());
        userResponseDto.setBirthDate(user.getBirthDate());
        userResponseDto.setName(user.getName());
        userResponseDto.setLastName(user.getLastName());
        return userResponseDto;
    }
}
