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
    @ValueSource(doubles = {5, 10, 15})
    void calculatorAdditionTest(double integers){
        //Given
        double expected = integers * 2;
        //When
        double result = calc.addition(integers, integers);
        //Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5, 10, 15})
    void calculatorSubtractionTest(double integers){
        // Given
        double base = 100;
        double expected = base - integers;
        // When
        double result = calc.subtraction(base, integers);
        // Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5, 10, 15})
    void calculatorMultiplicationTest(double integers){
        // Given
        double expected = integers * integers;
        // When
        double result = calc.multiplication(integers, integers);
        // Then
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {5, 10, 15})
    void calculatorDivisionTest(double integers){
        // Given
        double expected = integers / integers;
        // When
        double result = calc.division(integers, integers);
        // Then
        Assertions.assertEquals(expected, result);
    }
}