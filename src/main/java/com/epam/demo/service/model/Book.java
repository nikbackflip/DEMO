package com.epam.demo.service.model;

import com.epam.demo.controller.dto.Genre;
import lombok.Data;

import java.util.Set;

@Data
public class Book {

    public String id;
    public String authorId;
    public String title;
    public String description;
    public int pages;
    public int publicationYear;
    public Set<Genre> genres;

}
