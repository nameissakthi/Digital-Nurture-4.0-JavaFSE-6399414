package com.example.mockingservicedependency.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "-1, 1, 0",
            "5, 5, 10",
            "100, 200, 300"
    })
    public void testAdd(int a, int b, int expected){
        int result = calculatorService.add(a, b);
        assertEquals(expected, result);
    }
}