package com.sparta.gh.calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    public void Calculator() {
    }

    public double addition(double inputOne, double inputTwo) {
        return inputOne + inputTwo;
    }

    public int subtraction(ArrayList<Integer> ints) {
        if (ints.size() > 0){
            int total = ints.get(0);
            for (int i = 1; i < ints.size(); i++) {
                total -= ints.get(i);
            }
            return total;
        } else{
            System.out.println("Error in subtraction - array empty!");
            return 0;
        }
    }
}
