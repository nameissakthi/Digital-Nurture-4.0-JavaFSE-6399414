package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService( @Autowired CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountriesByKeyword( String keyword ) {
        return countryRepository.findByNameContaining(keyword);
    }

    public List<Country> getAllCountriesByKeywordOrderByNameAsc( String keyword ) {
        return countryRepository.findByNameContainingOrderByNameAsc(keyword);
    }

    public List<Country> getAllCountriesByKeywordStartingWith( String keyword ) {
        return countryRepository.findByNameStartingWith(keyword);
    }
}
