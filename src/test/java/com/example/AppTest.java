
package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AppTest {

    // Test 1: BMI calculation for known values
    @Test
    void testBMICalculation() {
        double bmi = App.calculateBMI(70, 1.75);

        assertEquals(22.86, bmi, 0.01);
    }

    // Test 2: BMI category boundary testing
    @ParameterizedTest
    @CsvSource({
        "18.49, Underweight",
        "18.5, Normal weight",
        "24.99, Normal weight",
        "25.0, Overweight",
        "29.99, Overweight",
        "30.0, Obese"
    })
    void testBMICategory(double bmi, String expected) {
        assertEquals(expected, App.getCategory(bmi));
    }

    // Test 3: Zero and negative weight validation
    @ParameterizedTest
    @CsvSource({
        "0, 1.75",
        "-70, 1.75"
    })
    void testInvalidWeight(double weight, double height) {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(weight, height));
    }

    // Test 4: Zero and negative height validation
    @ParameterizedTest
    @CsvSource({
        "70, 0",
        "70, -1.75"
    })
    void testInvalidHeight(double weight, double height) {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(weight, height));
    }

    // Test 5: Extreme input validation
    @ParameterizedTest
    @CsvSource({
        "501, 1.75",
        "70, 3.1",
        "70, 0.2"
    })
    void testExtremeValues(double weight, double height) {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(weight, height));
    }

    // Test 6: NaN and Infinity validation
    @Test
    void testNonFiniteValues() {

        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(Double.NaN, 1.75));

        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(70, Double.POSITIVE_INFINITY));
    }

    // Test 7: Invalid BMI validation
    @Test
    void testInvalidBMI() {

        assertThrows(IllegalArgumentException.class,
            () -> App.getCategory(-1));

        assertThrows(IllegalArgumentException.class,
            () -> App.getCategory(Double.NaN));
    }
}
