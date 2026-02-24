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
    public static boolean check(String str, int s, int e) {
        if (s >= e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        return check(str, s + 1, e - 1);
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama";
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean result = check(clean, 0, clean.length() - 1);
        System.out.println(result);
    }
}}