package com.example.library;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class Utils {

    // Poorly named variable, magic number example
    private int x = 100;

    /**
     * caldicount  discounted
     *
     * @param price jaja jajajaaj postive number
     * @return  reduced pricd
     */
    public int calculateDiscount(int price) {
        // PMD should flag this as a "magic number"
        try {
            price =  price - 10;
        } catch (Exception e) {
            throw new RuntimeException("This should never happen");
        }
        return price;
    }

    // PMD should flag this as unused method
    private void helperMethod() {
        System.out.println("Helper method");
    }

    File openFile(String filename){
        try {
            Files.readAllLines(Paths.get(filename));
        } catch (IOException | RuntimeException e) {
            exit(1);
        }
    }
}
