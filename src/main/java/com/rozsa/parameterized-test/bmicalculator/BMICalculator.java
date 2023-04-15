package com.rozsa.parameterizedtest.bmicalculator;

import java.util.Comparator;
import java.util.List;

public class BMICalculator {

    private static final double BMI_THRESHOLD = 25.0;

    public boolean isDietRecommended(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi < BMI_THRESHOLD)
            return false;
        return true;
    }

    public Programmer findCoderWithWorstBMI(List<Programmer> coders) {
        return coders.stream()
                .sorted(Comparator.comparing(this::calculateBMI))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    public double[] getBMIScores(List<Programmer> coders) {
        double[] bmiScores = new double[coders.size()];
        for (int i = 0; i < bmiScores.length; i++) {
            bmiScores[i] = calculateBMI(coders.get(i));
        }
        return bmiScores;
    }

    private double calculateBMI(Programmer coder) {
        double height = coder.getHeight();
        double weight = coder.getWeight();
        if (height == 0.0)
            throw new ArithmeticException();
        double bmi = weight / (height * height);
        return Math.round(bmi * 100) / 100.0;
    }

}
