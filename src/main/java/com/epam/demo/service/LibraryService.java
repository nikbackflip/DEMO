package com.epam.demo.service;

import com.epam.demo.controller.dto.AuthorDto;
import com.epam.demo.controller.dto.BookDto;

import java.util.Set;

public interface LibraryService {
    AuthorDto getAuthorInfo(String authorId);

    AuthorDto createAuthor(AuthorDto authorDto);

    Set<BookDto> getAuthorBooks(String authorId);

    BookDto createBook(String authorId, BookDto bookDto);
}
