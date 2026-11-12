
package com.example;

import java.util.Scanner;

public class App {

    // Method to calculate BMI
    public static double calculateBMI(double weight, double height) {

        if (!Double.isFinite(weight) || !Double.isFinite(height)) {
            throw new IllegalArgumentException(
                "Weight and height must be valid numbers.");
        }

        if (weight <= 0 || weight > 500) {
            throw new IllegalArgumentException(
                "Weight must be between 0 and 500 kg.");
        }

        if (height < 0.3 || height > 3.0) {
            throw new IllegalArgumentException(
                "Height must be between 0.3 and 3.0 metres.");
        }

        return weight / (height * height);
    }

    // Method to determine BMI category
    public static String getCategory(double bmi) {

        if (!Double.isFin70ite(bmi) || bmi < 0) {
            throw new IllegalArgumentException("Invalid BMI value.");
        }

        if (bmi < 18.5) {
            return "Underweight";
        } 
        else if (bmi < 25.0) {
            return "Normal weight";
        } 
        else if (bmi < 30.0) {
            return "Overweight";
        } 
        else {
            return "Obese";
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("===== BMI CALCULATOR =====");

            System.out.print("Enter weight in kilograms: ");
            double weight = sc.nextDouble();

            System.out.print("Enter height in metres: ");
            double height = sc.nextDouble();

            double bmi = calculateBMI(weight, height);

            String category = getCategory(bmi);

            System.out.printf("Your BMI is: %.2f%n", bmi);

            System.out.println("BMI Category: " + category);

        } 
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter numeric values only.");
        } 
        finally {
            sc.close();
        }
    }
}
