package org.example;

public class FoodItem {

    private String name; // PMD: Magic number can be flagged here
    private int calories;

    public FoodItem(String name, int calories) {
        if (calories < 0) {
            throw new IllegalArgumentException("Calories cannot be negative");
        }
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}
