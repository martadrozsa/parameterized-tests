package com.rozsa.parameterizedtest.bmicalculator;

import lombok.Data;

@Data
public class Programmer {

    private double height;
    private double weight;
    private int age;
    private Gender gender;

    public Programmer(double height, double weight) {
        super();
        this.height = height;
        this.weight = weight;
    }

}
