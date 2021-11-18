package com.epam.demo.service.mapper;

import com.epam.demo.controller.dto.AuthorDto;
import com.epam.demo.service.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto mapAuthorDto(Author author);

    Author mapAuthor(AuthorDto authorDto);
}
