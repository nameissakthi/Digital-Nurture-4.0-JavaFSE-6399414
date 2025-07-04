package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService(@Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Transactional
    public Country findCountryByCode( String code ) throws CountryNotFoundException {
        Optional<Country> result = countryRepository.findById(code);

        if(!result.isPresent())
            throw new CountryNotFoundException();

        return result.get();
    }
}
