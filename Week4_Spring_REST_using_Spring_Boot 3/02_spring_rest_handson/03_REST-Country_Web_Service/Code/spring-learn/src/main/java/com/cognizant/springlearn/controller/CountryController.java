package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/country")
    public Country getCountryIndia() {
        return new ClassPathXmlApplicationContext("springConfig.xml").getBean("india", Country.class);
    }
}