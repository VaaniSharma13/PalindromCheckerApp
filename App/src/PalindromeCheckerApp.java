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

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "radar";
        boolean result = checkPalindrome(input);
        System.out.println(result);
    }

    public static boolean checkPalindrome(String str) {
        if (str == null) return false;

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}