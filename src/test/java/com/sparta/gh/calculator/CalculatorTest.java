package com.sparta.gh.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

class CalculatorTest {

    Calculator calc = new Calculator();

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    void calculatorAdditionTest(int integers){
        //Given
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(integers);
        ints.add(integers);
        ints.add(integers);
        ints.add(integers);
        int expected = integers * 4;
        //When
        int result = calc.addition(ints);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 13, 156})
    void calculatorSubtractionTest(int integers){
        // Given
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(50);
        ints.add(integers);
        ints.add(integers);
        ints.add(integers);
        ints.add(integers);

        int expected = (50 - (integers*4));
        // When
        int result = calc.subtraction(ints);
        // Then
        Assertions.assertEquals(expected, result);
    }
}