package com.epam.demo.service.repository.impl;

import com.epam.demo.service.model.Author;
import com.epam.demo.service.repository.AuthorRepository;
import com.epam.demo.service.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {

    private final BookRepository bookRepo;

    private Map<String, Author> authors = new HashMap<>();

    @Override
    public Author getById(String authorId) {
        Author author = authors.get(authorId);
        author.setBooks(bookRepo.getBooksByAuthor(authorId));
        return author;
    }

    @Override
    public Author create(Author author) {
        String id = UUID.randomUUID().toString();
        author.setId(id);
        authors.put(id, author);
        return author;
    }
}
