package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public List<String> getBookList() {
        return Arrays.asList("Effective Java", "Spring in Action", "Clean Code");
    }
}
