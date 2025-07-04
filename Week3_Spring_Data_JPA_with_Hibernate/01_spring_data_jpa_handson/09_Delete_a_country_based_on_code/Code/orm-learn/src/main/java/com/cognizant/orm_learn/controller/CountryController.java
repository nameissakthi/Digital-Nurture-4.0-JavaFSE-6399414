package com.cognizant.orm_learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.orm_learn.service.CountryService;

@RestController
public class CountryController {
	
	private CountryService countryService;
	
	public CountryController( @Autowired CountryService countryService  ) {
		this.countryService = countryService;
	}
	
	@DeleteMapping("/country/delete/{code}")
	public String deleteCountry( @PathVariable String code ) {
		return countryService.deleteCountry(code);
	}
}
