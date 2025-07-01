package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.example.service.BookService.displayBooks())")
    public void beforeFetchingBooks(){
        System.out.println("fetching books from database");
    }

    @After("execution(* com.example.service.BookService.displayBooks())")
    public void afterFetchingBooks(){
        System.out.println("Books fetched");
    }
}
