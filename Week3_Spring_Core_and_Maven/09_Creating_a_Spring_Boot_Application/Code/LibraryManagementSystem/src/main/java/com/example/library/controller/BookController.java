package com.example.library.controller;


import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(){
        return "API Working!!!";
    }

    @GetMapping("/books/list")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/get/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/books/add")
    public String addBook( @RequestBody Book book ) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteBookById(@PathVariable int id){
        return bookService.deleteBookById(id);
    }

    @PutMapping("/books/update")
    public String updateBookById(@RequestBody Book book){
        return bookService.updateBookById(book);
    }
}
