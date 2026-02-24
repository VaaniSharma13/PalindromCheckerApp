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

public class PalindromeCheckerApp {
    private String normalize(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private boolean isRecursivePalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isRecursivePalindrome(str, start + 1, end - 1);
    }

    public boolean checkPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String clean = normalize(input);
        return isRecursivePalindrome(clean, 0, clean.length() - 1);
    }

    public static void main(String[] args) {
        PalindromeCheckerApp service = new PalindromeCheckerApp();

        System.out.println(service.checkPalindrome("Was it a car or a cat I saw?"));
        System.out.println(service.checkPalindrome("Hello World"));
    }
}}