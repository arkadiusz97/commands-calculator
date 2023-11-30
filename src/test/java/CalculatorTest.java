package com.github.arkadiusz97.recruitment.commands_calculator.service;

import com.github.arkadiusz97.recruitment.commands_calculator.exception.CalculatorException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    @DisplayName("test valid cases")
    void testValidCases() {
        Calculator calculator = new Calculator();
        Integer result1 = 0;
        Integer result2 = 0;
        try {
            result1 = calculator.runCalculator("src\\test\\resources\\test-file-1.txt");
            result2 = calculator.runCalculator("src\\test\\resources\\test-file-2.txt");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        assertEquals(result1,36, "should calculate value from 1 file");
        assertEquals(result2,32, "should calculate value from 1 file");
    }

    @Test
    @DisplayName("test invalid cases")
    void testInvalidCases() {
        Calculator calculator = new Calculator();
        Throwable exception1 = assertThrows(CalculatorException.class, () ->
            calculator.runCalculator("src\\test\\resources\\test-file-invalid-number-of-arguments.txt")
        );
        Throwable exception2 = assertThrows(CalculatorException.class, () ->
            calculator.runCalculator("src\\test\\resources\\test-file-last-argument-is-not-apply.txt")
        );
        assertEquals("Invalid number of arguments in line: apply 10 a", exception1.getMessage());
        assertEquals("The last command is not apply", exception2.getMessage());
    }

}
