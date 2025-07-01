package com.example;

import com.example.service.LoggingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("Application is starting\n");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        LoggingService service = context.getBean(LoggingService.class);

        System.out.println();

        service.login();
    }
}
