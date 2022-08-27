package com.example.tripapp.service.mapper;

public interface AbstractDtoMapper <ResponseDto, Model, RequestDto>{
    Model toModel(RequestDto requestDto);

    ResponseDto toDto(Model entity);
}
