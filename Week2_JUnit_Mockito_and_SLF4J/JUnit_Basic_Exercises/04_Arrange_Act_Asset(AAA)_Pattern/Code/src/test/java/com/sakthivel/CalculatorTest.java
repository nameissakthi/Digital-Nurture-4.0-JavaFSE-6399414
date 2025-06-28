package com.sakthivel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting Up Calculator...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing down Calculator...");
        calculator = null;
    }

    @Test
    public void add() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void sub() {
        assertEquals(-1, calculator.sub(1, 2));
    }

    @Test
    public void mul() {
        assertEquals(2, calculator.mul(1, 2));
    }

    @Test
    public void div() {
        assertEquals(5, calculator.div(10, 2));
    }
}