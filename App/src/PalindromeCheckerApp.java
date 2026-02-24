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

class StackStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) {
            stack.push(c);
        }
        for (char c : clean.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean isValid(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();
        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String text) {
        return strategy.isValid(text);
    }

    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        String test = "Race Car";

        app.setStrategy(new StackStrategy());
        System.out.println(app.check(test));

        app.setStrategy(new DequeStrategy());
        System.out.println(app.check(test));
    }
}