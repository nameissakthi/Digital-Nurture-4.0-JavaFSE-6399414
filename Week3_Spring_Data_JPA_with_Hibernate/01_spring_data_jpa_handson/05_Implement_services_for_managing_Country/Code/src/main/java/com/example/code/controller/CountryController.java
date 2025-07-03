package com.example.code.controller;

import com.example.code.model.Country;
import com.example.code.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("country")
public class CountryController {

    private CountryService countryService;

    public CountryController(@Autowired CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("list")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("get/{code}")
    public Country getCountryById( @PathVariable String code ) {
        return countryService.getCountryByCode(code);
    }

    @PostMapping("add")
    public String addNewCountry( @RequestBody Country country ) {
        return countryService.addNewCountry(country);
    }

    @PutMapping("update")
    public String updateCountry( @RequestBody Country country ) {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("delete/{code}")
    public String deleteCountry( @PathVariable String code ) {
        return countryService.deleteCountry(code);
    }
}
