package com.cognizant.orm_learn.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.cognizant.orm_learn.repository.CountryRepository;

import jakarta.transaction.Transactional;

import com.cognizant.orm_learn.model.Country;

@Service
public class CountryService {
	
	private final CountryRepository countryRepository;
	
	public CountryService( @Autowired CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@Transactional
	public List<Country> getAllCountry() {
		return countryRepository.findAll();
	}
	
}
