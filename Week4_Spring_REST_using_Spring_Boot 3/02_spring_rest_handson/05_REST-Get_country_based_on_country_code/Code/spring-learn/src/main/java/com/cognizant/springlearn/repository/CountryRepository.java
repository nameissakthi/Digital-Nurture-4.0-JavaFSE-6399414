package com.cognizant.springlearn.repository;

import com.cognizant.springlearn.model.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CountryRepository {

    private List<Country> countries;

    public CountryRepository( @Autowired List<Country> countries) {
        this.countries = new ArrayList<>(countries);
    }

    public Country findByCode(String code) {
        for(int i=0;i<countries.size();i++)
            if(countries.get(i).getCode().equalsIgnoreCase(code))
                return countries.get(i);
        return new Country();
    }
}