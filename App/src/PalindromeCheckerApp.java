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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        String input = "level";
        boolean result = compareStructures(input);
        System.out.println(result);
    }

    public static boolean compareStructures(String str) {
        if (str == null) return false;

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }

        return true;
    }
}