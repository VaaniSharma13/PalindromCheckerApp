/**
 * MAIN CLASS - UseCasePalindromeApp
 *
 * Use Case 1 : Application Entry and Welcome Message
 *
 * Description:
 * This class represents the entry point of the
 * Palindrome Checker management System
 *
 * At this stage, the application:
 * -Starts execution from the main() method
 * -display a welcome message
 * -Shows application version
 *
 * No palindrome logic is implemented here yet.
 *
 * the goal is to establish a clear startup flow.
 *
 * @vaani Developer
 * @version 1.0
 */

import java.util.*;

interface PalindromeStrategy {
    boolean isValid(String input);
}

class RecursiveStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return check(clean, 0, clean.length() - 1);
    }
    private boolean check(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return check(s, start + 1, end - 1);
    }
}

class IterativeStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int s = 0, e = clean.length() - 1;
        while (s < e) {
            if (clean.charAt(s++) != clean.charAt(e--)) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String largeInput = "A".repeat(1000) + "B" + "A".repeat(1000);

        compare(new RecursiveStrategy(), "Recursive", largeInput);
        compare(new IterativeStrategy(), "Iterative", largeInput);
    }

    private static void compare(PalindromeStrategy strategy, String name, String input) {
        long start = System.nanoTime();
        boolean result = strategy.isValid(input);
        long end = System.nanoTime();

        System.out.println(name + " Strategy:");
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}