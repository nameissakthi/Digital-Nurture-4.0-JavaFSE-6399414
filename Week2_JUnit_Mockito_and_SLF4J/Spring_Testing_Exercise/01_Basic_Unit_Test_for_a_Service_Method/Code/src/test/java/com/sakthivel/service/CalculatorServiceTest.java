package com.sakthivel.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void add() {
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(5, calculatorService.add(2, 3));
    }
}