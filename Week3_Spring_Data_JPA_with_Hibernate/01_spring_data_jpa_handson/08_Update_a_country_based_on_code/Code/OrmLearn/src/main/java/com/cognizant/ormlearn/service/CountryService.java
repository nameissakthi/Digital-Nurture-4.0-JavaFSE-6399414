package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    public CountryService( @Autowired CountryRepository countryRepository ) {
        this.countryRepository = countryRepository;
    }


    @Transactional
    public String updateCountry(String code, String name) {
        try{
            Country country = countryRepository.findById(code).orElse(null);
            assert country != null;

            country.setName(name);

            countryRepository.save(country);
            return  "Country Updated Successfully";
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
