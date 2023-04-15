package com.rozsa.parameterizedtest.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculatorTest {

    private static com.rozsa.parameterizedtest.calculator.Calculator calculator;

    @BeforeAll
    static void setup() {
        calculator = new com.rozsa.parameterizedtest.calculator.Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2.0, 5.0, SUM, 7.0",
            "10.5, 6.3, SUB, 4.2",
            "3.0, 4.0, MUL, 12.0",
            "25.0, 5.0, DIV, 5.0",
            "2.0, 5.0, LOG, 7.0"
    })
    void calculator(Double num1, Double num2, com.rozsa.parameterizedtest.calculator.OperationType operation, Double expected) {
        Double res = calculator.execOperation(num1, num2, operation);

        assertEquals(expected, res);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/scenarios/scenario01.csv", numLinesToSkip = 1)
    void calculatorFromCsv(Double num1, Double num2, com.rozsa.parameterizedtest.calculator.OperationType operation, Double expected) {
        Double res = calculator.execOperation(num1, num2, operation);

        assertEquals(expected, res);
    }
}
