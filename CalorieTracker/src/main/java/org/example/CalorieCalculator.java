package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class CalorieCalculator {

    // Unused field (will be flagged by PMD)
    private static final double UNUSED_CONSTANT = 1.15;

    // Magic number (500) for bulking surplus, which PMD will flag
    private static final double BULK_SURPLUS = 500;
    private static final double MAINTENANCE_FACTOR = 1.2;

    public CalorieCalculator() {
        // Unnecessary constructor in a utility class (flagged by PMD)
    }

    public static double calculateBMR(String gender, int age, double weightKg, double heightCm) {
        double bmr;
        if ("male".equalsIgnoreCase(gender)) {
            bmr = 88.362 + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weightKg) + (3.098 * heightCm) - (4.330 * age);
        }
        return bmr;
    }

    public static double calculateDailyCalories(double bmr, double activityLevel) {
        // Magic number example (1.5)
        return bmr * activityLevel * 1.5;
    }
    public int slimming(int weight) {
        // PMD should flag this as a "magic number"
        try {
            weight = weight - 10;
        } catch (Exception e) {
            throw new RuntimeException("This should never happens");
        }
        return weight;
    } 
    // Unused private method (flagged by PMD)
    private void helperMethod() {
        System.out.println("This is an unused helper method.");
    }

    public static double calculateBulkingCalories(double dailyCalories) {
        return dailyCalories + BULK_SURPLUS;
    }

    public static double calculateMaintenanceCalories(double bmr) {
        return bmr * MAINTENANCE_FACTOR;
    }



}
