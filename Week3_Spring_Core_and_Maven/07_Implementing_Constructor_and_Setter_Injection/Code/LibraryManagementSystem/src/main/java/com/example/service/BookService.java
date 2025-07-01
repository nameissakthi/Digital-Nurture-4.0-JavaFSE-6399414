package com.example.service;

import com.example.repository.BookRepository;

public class BookService {

    private String libraryName;
    private BookRepository bookRepository;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookService() {
        System.out.println("BookService Created");
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void getBooks(){
        System.out.println("Books : "+bookRepository.getBooks());
    }
}
