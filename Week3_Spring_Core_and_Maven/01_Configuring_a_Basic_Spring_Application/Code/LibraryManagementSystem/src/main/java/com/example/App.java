package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Starting the Application");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}