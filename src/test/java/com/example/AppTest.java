
package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

    // Test Case 1: BMI Calculation - INTENTIONAL FAILURE
    @Test
    void testBMICalculation() {
        double bmi = App.calculateBMI(70, 1.75);

        assertEquals(25.00, bmi, 0.01);
    }

    // Test Case 2: Normal BMI Category - SUCCESS
    @Test
    void testNormalCategory() {
        assertEquals("Normal weight", App.getCategory(22.86));
    }

    // Test Case 3: Invalid Weight - SUCCESS
    @Test
    void testInvalidWeight() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(-70, 1.75));
    }

    // Test Case 4: Invalid Height - SUCCESS
    @Test
    void testInvalidHeight() {
        assertThrows(IllegalArgumentException.class,
            () -> App.calculateBMI(70, -1.75));
    }
}
