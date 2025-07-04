package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnApplication {

    static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void getAllCountriesTest(ApplicationContext context) {
        CountryService service = context.getBean(CountryService.class);
        LOGGER.info("Start");
        Country country = service.findCountryByCode("IN");
        LOGGER.debug("Country : {}", country);
        LOGGER.info("End");
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        getAllCountriesTest(context);
    }

}
