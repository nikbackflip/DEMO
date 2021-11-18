package com.epam.demo.service.model;

import lombok.Data;

import java.util.Set;

@Data
public class Author {

    public String id;
    public String name;
    public String nickname;
    Set<Book> books;

}
