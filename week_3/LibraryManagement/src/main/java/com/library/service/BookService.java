package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;
    private String libraryName;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Welcome to " + libraryName + "!");
        List<String> books = bookRepository.getBookList();
        System.out.println("Available Books:");
        books.forEach(book -> System.out.println("- " + book));
    }
}
