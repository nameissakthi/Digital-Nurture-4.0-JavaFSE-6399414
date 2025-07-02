package com.cognizant.orm_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import java.util.List;

import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.model.Country;

@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		
		LOGGER.info("Inside main");
		
		countryService = context.getBean(CountryService.class);
		
		testGetAllCountries();
	}
	
	public static void testGetAllCountries() {
		LOGGER.info("Start");
		
		List<Country> countries = countryService.getAllCountry();
		
		LOGGER.debug("countries={}", countries);
		
		LOGGER.info("End");
	}
}
