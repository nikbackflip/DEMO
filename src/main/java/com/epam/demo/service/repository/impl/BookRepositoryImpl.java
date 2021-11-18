package com.epam.demo.service.repository.impl;

import com.epam.demo.service.model.Book;
import com.epam.demo.service.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class BookRepositoryImpl implements BookRepository {

    private Map<String, Book> books = new HashMap<>();

    @Override
    public Book createBook(Book newBook) {
        String id = UUID.randomUUID().toString();
        newBook.setId(id);
        books.put(id, newBook);
        return newBook;
    }

    @Override
    public Set<Book> getBooksByAuthor(String authorId) {
        return books.values().stream()
                .filter(b -> b.getAuthorId().equals(authorId))
                .collect(Collectors.toSet());
    }
}
