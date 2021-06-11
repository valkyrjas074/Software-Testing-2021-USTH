Exercise 4.1
Submit printouts of all tests, your final version of Calc, and a screenshot showing that all tests pass.
	
Calc.java
public class Calc {
    static public int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(float a, float b) {
        return a / b;
    }
}
	
TestCalc.java
package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestCalc {
    Calc calc = new Calc();
    private int a = 6;
    private int b = 4;

    @Test
    public void testAdd() {
        assertEquals(calc.add(a, b), 10);
    }

    @Test
    public void testMinus() {
        assertEquals(calc.minus(a, b), 2);
    }

    @Test
    public void testMultiply() {
        assertEquals(calc.multiply(a, b), 24);
    }

    @Test
    public void testDivide() {
        assertEquals(calc.divide(a, b), 1, 2);
    }
}