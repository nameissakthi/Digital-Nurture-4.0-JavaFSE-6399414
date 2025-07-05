package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    static Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void testQueryMethods(ApplicationContext context) {
        LOGGER.info("Start...");
        CountryService service = context.getBean(CountryService.class);

        List<Country> countries = service.getAllCountriesByKeyword("ou");
        LOGGER.debug("GET ALL COUNTRIES BY KEYWORD:\n {}", countries);

        countries = service.getAllCountriesByKeywordOrderByNameAsc("ou");
        LOGGER.debug("GET ALL COUNTRIES BY KEYWORD ORDER BY NAME IN ASCENDING:\n {}", countries);

        countries = service.getAllCountriesByKeywordStartingWith("Z");
        LOGGER.debug("GET ALL COUNTRIES BY KEYWORD STARTING WITH:\n {}", countries);

        LOGGER.info("End...");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        testQueryMethods(context);
    }
}
