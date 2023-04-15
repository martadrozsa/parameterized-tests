package com.rozsa.parameterizedtest.calculator;

@FunctionalInterface
public interface Operation {
    Double calculate(Double num1, Double num2);
}
