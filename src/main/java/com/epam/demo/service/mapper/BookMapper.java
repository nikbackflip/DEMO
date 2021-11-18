package com.epam.demo.service.mapper;

import com.epam.demo.controller.dto.BookDto;
import com.epam.demo.service.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Set<BookDto> mapBookDtos(Set<Book> books);

    BookDto mapBookDto(Book books);

    Book mapBook(BookDto dto);
}
