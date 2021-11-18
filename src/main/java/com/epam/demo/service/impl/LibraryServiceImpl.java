package com.epam.demo.service.impl;

import com.epam.demo.controller.dto.AuthorDto;
import com.epam.demo.controller.dto.BookDto;
import com.epam.demo.service.LibraryService;
import com.epam.demo.service.exception.EntityNotFoundException;
import com.epam.demo.service.mapper.AuthorMapper;
import com.epam.demo.service.mapper.BookMapper;
import com.epam.demo.service.model.Author;
import com.epam.demo.service.model.Book;
import com.epam.demo.service.repository.AuthorRepository;
import com.epam.demo.service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;

    @Override
    public AuthorDto getAuthorInfo(String authorId) {
        Author author = authorRepo.getById(authorId);
        if (author == null) {
            throw new EntityNotFoundException(format("Author with id %s not found", authorId));
        }
        return AuthorMapper.INSTANCE.mapAuthorDto(author);
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author newAuthor = authorRepo.create(AuthorMapper.INSTANCE.mapAuthor(authorDto));
        return AuthorMapper.INSTANCE.mapAuthorDto(newAuthor);
    }

    @Override
    public Set<BookDto> getAuthorBooks(String authorId) {
        Author author = authorRepo.getById(authorId);
        if (author == null) {
            throw new EntityNotFoundException(format("Author with id %s not found", authorId));
        }

        Set<Book> books = author.getBooks();
        return BookMapper.INSTANCE.mapBookDtos(books);
    }

    @Override
    public BookDto createBook(String authorId, BookDto bookDto) {
        Author author = authorRepo.getById(authorId);
        if (author == null) {
            throw new EntityNotFoundException(format("Author with id %s not found", authorId));
        }
        Book newBook = BookMapper.INSTANCE.mapBook(bookDto);
        newBook.setAuthorId(authorId);
        newBook = bookRepo.createBook(newBook);
        return BookMapper.INSTANCE.mapBookDto(newBook);
    }
}
