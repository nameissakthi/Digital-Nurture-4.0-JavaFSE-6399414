package com.example.service;

import com.example.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookService() {
        System.out.println("BookService Created");
    }

    public void displayBooks(){
        System.out.println("Books : "+bookRepository.getBooks());
    }
}
