package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryService {
	
	private CountryRepository countryRepository;
	
	public CountryService( @Autowired CountryRepository countryRepository ) {
		this.countryRepository = countryRepository;
	}
	
	@Transactional
	public String deleteCountry(String code) {
		try {
			countryRepository.deleteById(code);
			return "Country Deleted Successully";
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
