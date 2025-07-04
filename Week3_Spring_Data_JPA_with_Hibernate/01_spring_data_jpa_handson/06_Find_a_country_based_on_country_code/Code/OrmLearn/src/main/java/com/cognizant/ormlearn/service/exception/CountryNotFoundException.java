package com.cognizant.ormlearn.service.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("Country Not Found!!!");
    }
}
