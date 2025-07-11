package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(@Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }
}
