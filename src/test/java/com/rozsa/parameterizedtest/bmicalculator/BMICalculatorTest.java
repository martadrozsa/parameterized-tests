package com.rozsa.parameterizedtest.bmicalculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest { //Body Mass Index calculator

    static BMICalculator bmiCalculator;

    @BeforeAll
    static void setup() {
        bmiCalculator = new BMICalculator();
    }

    @Test
    void should_ReturnTrue_When_DietRecommended() {
        //given
        double weight = 89.0;
        double height = 1.72;

        //when
        boolean recommended = bmiCalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietRecommended() {
        //given
        double weight = 80.0;
        double height = 1.92;

        //when
        boolean recommended = bmiCalculator.isDietRecommended(weight, height);

        //then
        assertFalse(recommended);
    }

    @ParameterizedTest
    @ValueSource(doubles = {89.0, 78.0, 75.0})
    void should_ReturnTrue_When_DietRecommended(Double coderWeight) {
        //given
        double weight = coderWeight;
        double height = 1.72;

        //when
        boolean recommended = bmiCalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }

    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    void should_ReturnTrue_When_DietRecommended(Double coderWeight, Double coderHeight) {
        //given
        double weight = coderWeight;
        double height = coderHeight;

        //when
        boolean recommended = bmiCalculator.isDietRecommended(weight, height);

        //then
        assertTrue(recommended);
    }
}
