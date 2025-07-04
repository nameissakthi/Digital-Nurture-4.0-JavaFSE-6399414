package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    public static void testAddCountry( ApplicationContext context ) {
        CountryService countryService = context.getBean(CountryService.class);

        Country country = new Country("XY", "XYZ Country");
        countryService.addNewCountry(country);

        System.out.println(countryService.getCountryByCode("XY"));
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        testAddCountry(context);
    }

}
