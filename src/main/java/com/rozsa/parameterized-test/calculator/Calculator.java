package com.rozsa.parameterizedtest.calculator;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<OperationType, Operation> operations;

    public Calculator() {
        operations = new HashMap<>();
        operations.put(OperationType.SUM, this::sum);
        operations.put(OperationType.SUB, this::subtraction);
        operations.put(OperationType.MUL, this::multiplication);
        operations.put(OperationType.DIV, this::division);
    }

    private Double sum(Double num1, Double num2) {
        return num1 + num2;
    }

    private Double subtraction(Double num1, Double num2) {
        return num1 - num2;
    }

    private Double multiplication(Double num1, Double num2) {
        return num1 * num2;
    }

    private Double division(Double num1, Double num2) {
        return num1 / num2;
    }

    public Double execOperation(Double num1, Double num2, OperationType operation) {
        if (!operations.containsKey(operation)) {
            return sum(num1, num2);
        }

        Operation op = operations.get(operation);
        return op.calculate(num1, num2);
    }

//    public Double execOperation(Double num1, Double num2, OperationType operation) {
//        switch (operation) {
//            case SUB:
//                return subtraction(num1, num2);
//            case DIV:
//                return division(num1, num2);
//            case MUL:
//                return multiplication(num1, num2);
//            case SUM:
//            default:
//                return sum(num1, num2);
//        }
//    }
}
