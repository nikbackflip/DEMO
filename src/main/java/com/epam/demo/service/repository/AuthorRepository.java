package com.epam.demo.service.repository;

import com.epam.demo.service.model.Author;

public interface AuthorRepository {

    Author getById(String authorId);

    Author create(Author author);

}
