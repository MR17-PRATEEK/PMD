package com.example.library;

public class Book {

    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // PMD will likely suggest making this static
    public void displayBookInfo() {
        System.out.println(title + " by " + author);
    }
}
