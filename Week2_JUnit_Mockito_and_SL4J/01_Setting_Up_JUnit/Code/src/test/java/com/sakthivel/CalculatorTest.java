package com.sakthivel;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void add() {
        Calculator calculator = new Calculator();

        assertEquals(20, calculator.add(10, 10));
    }
}