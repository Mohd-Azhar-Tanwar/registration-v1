package com.api;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call the function to check for palindrome
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }

        // Close the scanner
        scanner.close();
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        // Remove spaces and convert the string to lowercase for case-insensitive comparison
        String cleanedString = str.replaceAll("\\s+", "").toLowerCase();

        int length = cleanedString.length();
        for (int i = 0; i < length / 2; i++) {
            // Compare characters from both ends of the string
            if (cleanedString.charAt(i) != cleanedString.charAt(length - i - 1)) {
                return false; // If any character doesn't match, it's not a palindrome
            }
        }
        return true; // If all characters match, it's a palindrome
    }
}

