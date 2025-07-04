package com.cognizant.ormlearn.controller;

import com.cognizant.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    private CountryService countryService;

    public CountryController( @Autowired CountryService countryService ) {
        this.countryService = countryService;
    }

    @PutMapping("/country/update")
    public String updateCountry(@RequestParam String code, @RequestParam String name) {
        return countryService.updateCountry(code, name);
    }
}
