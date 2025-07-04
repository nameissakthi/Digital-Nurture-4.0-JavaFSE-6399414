package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

public class CountryService {

    private CountryRepository countryRepository;

    public CountryService( @Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public void addNewCountry(Country country) {
        countryRepository.save(country);
    }
}
