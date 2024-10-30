package org.example;

public final class CalorieCalculator {

    private static final double BULKING_CALORIE_SURPLUS = 500.0;
    private static final double MAINTENANCE_CALORIE_FACTOR = 1.2;
    private static final double MALE_BMR_BASE = 88.362;
    private static final double FEMALE_BMR_BASE = 447.593;

    // Private constructor to prevent instantiation
    private CalorieCalculator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    /**
     * Calculates the Basal Metabolic Rate (BMR) based on gender, age, weight, and height.
     *
     * @param gender   the gender of the individual (male/female)
     * @param age      the age of the individual in years
     * @param weightKg the weight of the individual in kilograms
     * @param heightCm the height of the individual in centimeters
     * @return the calculated BMR
     */

    public static double calculateBMR(String gender, int age, double weightKg, double heightCm) {
        double bmr;
        if ("male".equalsIgnoreCase(gender)) {
            bmr = MALE_BMR_BASE + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age);
        } else {
            bmr = FEMALE_BMR_BASE + (9.247 * weightKg) + (3.098 * heightCm) - (4.330 * age);
        }
        return bmr;
    }

    /**
     * Calculates daily caloric needs based on BMR and activity level.
     *
     * @param bmr           the Basal Metabolic Rate
     * @param activityLevel the activity level factor (e.g., 1.2 to 1.9)
     * @return the calculated daily caloric needs
     */

    public static double calculateDailyCalories(double bmr, double activityLevel) {
        return bmr * activityLevel;
    }

    public static double calculateBulkingCalories(double dailyCalories) {
        return dailyCalories + BULKING_CALORIE_SURPLUS;
    }

    public static double calculateMaintenanceCalories(double bmr) {
        return bmr * MAINTENANCE_CALORIE_FACTOR;
    }
}
