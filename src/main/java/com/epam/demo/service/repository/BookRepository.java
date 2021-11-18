package com.epam.demo.service.repository;

import com.epam.demo.service.model.Book;

import java.util.Set;

public interface BookRepository {
    Book createBook(Book newBook);
    Set<Book> getBooksByAuthor(String authorId);
}

