package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalorieTrackerApp {

    private List<FoodItem> foodItems;
    private List<User> users;
    private User currentUser;

    // Magic number example; will be flagged by PMD
    private static final int caloriedesire = 4250; // PMD: Magic number

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
        try {
            int choice = 0;
            while (choice != 5) { // Adjusted to 5 to include user management
                System.out.println("Calorie Tracker");
                System.out.println("1. Register User");
                System.out.println("2. Login User");
                System.out.println("3. Add Food Item");
                System.out.println("4. Calculate Discount");
                System.out.println("5. Exit");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        registerUser(scanner);
                        break;
                    case 2:
                        loginUser(scanner);
                        break;
                    case 3:
                        addFoodItem(scanner);
                        break;
                    case 4:
                        calculatefoodintake(scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } finally {
            scanner.close();
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

    private void loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + username + "!");
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    private void addFoodItem(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("You must be logged in to add food items.");
            return;
        }

        System.out.print("Enter food name: ");
        String name = scanner.next();

        System.out.print("Enter calorie count: ");
        int calories = scanner.nextInt();

        try {
            FoodItem foodItem = new FoodItem(name, calories);
            foodItems.add(foodItem);
            System.out.println("Food item added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding food item: " + e.getMessage());
        }
    }

    private void calculatefoodintake(Scanner scanner) {
        System.out.print("Enter the choice of calorie needed for you: ");
        int CALORIE = scanner.nextInt();

        try {
            int dailyintake = 0;
            CALORIE = CALORIE - dailyintake; // Applying the discount
        } catch (Exception e) {
            throw new RuntimeException("This should never happen");
        }
        System.out.println("The CALORIE after Fasting is: " + CALORIE);
    }
}
