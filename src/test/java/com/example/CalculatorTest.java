package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "add");
        assertEquals(15, result);
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "sub");
        assertEquals(5, result);
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        int result = calc.calculate(10, 5, "mul");
        assertEquals(50, result);
    }
}
