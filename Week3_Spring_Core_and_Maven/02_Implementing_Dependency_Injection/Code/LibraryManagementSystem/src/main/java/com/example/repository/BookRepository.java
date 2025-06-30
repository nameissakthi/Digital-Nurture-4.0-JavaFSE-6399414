package com.example.repository;

public class BookRepository {

    public BookRepository() {
        System.out.println("BookRepository Created");
    }

    @Override
    public String toString(){
        return "BookRepository Injected";
    }
}