package com.sakthivel;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

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