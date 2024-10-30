package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalorieTrackerApp {

    private List<FoodItem> foodItems;
    private List<User> users;
    private User currentUser;

    private static final int EXIT_OPTION = 7;
    private static final int DISCOUNT_AMOUNT = 10;
    private static final int BULKING_CALORIE_SURPLUS = 500;

    public CalorieTrackerApp() {
        foodItems = new ArrayList<>();
        users = new ArrayList<>();
    }

    public static void main(String[] args) {
        CalorieTrackerApp app = new CalorieTrackerApp();
        app.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != EXIT_OPTION) {
            System.out.println("Calorie Tracker");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Add Food Item");
            System.out.println("4. Calculate Discount");
            System.out.println("5. Calculate Calorie Surplus for Bulking");
            System.out.println("6. Calculate Daily Calorie Needs");
            System.out.println("7. Exit");

            try {
                choice = scanner.nextInt();
                handleMenuChoice(scanner, choice);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        scanner.close();
    }

    private void handleMenuChoice(Scanner scanner, int choice) {
        switch (choice) {
            case 1 -> registerUser(scanner);
            case 2 -> loginUser(scanner);
            case 3 -> addFoodItem(scanner);
            case 4 -> calculateDiscount(scanner);
            case 5 -> calculateCalorieSurplus(scanner);
            case 6 -> calculateDailyCalorieNeeds(scanner);
            case EXIT_OPTION -> System.out.println("Exiting...");
            default -> System.out.println("Invalid option. Please try again.");
        }
    }

    private void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User user = new User(username, password);
        users.add(user);
        System.out.println("User registered successfully.");
    }

    private void calculateDiscount(Scanner scanner) {
        System.out.print("Enter the original price: ");
        int price = scanner.nextInt();
        int discountedPrice = price - DISCOUNT_AMOUNT;
        System.out.println("The price after discount is: " + discountedPrice);
    }

    private void calculateCalorieSurplus(Scanner scanner) {
        System.out.print("Enter your current calorie intake: ");
        int currentCalories = scanner.nextInt();
        int totalCaloriesForBulking = currentCalories + BULKING_CALORIE_SURPLUS;
        System.out.println("To bulk, you need a total of " + totalCaloriesForBulking + " calories.");
    }

    private void calculateDailyCalorieNeeds(Scanner scanner) {
        System.out.print("Enter your gender (male/female): ");
        String gender = scanner.next();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your weight in kg: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in cm: ");
        double height = scanner.nextDouble();
        System.out.print("Enter your activity level (1.2 to 1.9): ");
        double activityLevel = scanner.nextDouble();

        double bmr = CalorieCalculator.calculateBMR(gender, age, weight, height);
        double dailyCalories = CalorieCalculator.calculateDailyCalories(bmr, activityLevel);
        double bulkingCalories = CalorieCalculator.calculateBulkingCalories(dailyCalories);

        System.out.println("BMR: " + bmr + " calories");
        System.out.println("Daily Calorie Requirement: " + dailyCalories + " calories");
        System.out.println("Bulking Calories: " + bulkingCalories + " calories");
    }
}
