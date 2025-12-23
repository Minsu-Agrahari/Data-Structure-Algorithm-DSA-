/*
 * Duplicate Parentheses Checker
 * This program checks if there are any duplicate parentheses in a given expression.
 */
import java.util.Stack;

public class DuplicateParenthesesChecker {

    // Function to check for duplicate parentheses
    public static boolean hasDuplicateParentheses(String expression) {
        // Stack to store characters of the expression
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            // If current character is not a closing parenthesis, push it to the stack
            if (currentChar != ')') {
                stack.push(currentChar);
            } else {
                // Counter to check how many characters are inside the current parenthesis
                int insideParenthesisCount = 0;

                // Pop until opening parenthesis is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    insideParenthesisCount++;
                }

                // If no content or only one character inside '()', it's a duplicate
                if (insideParenthesisCount <= 1) {
                    return true; // duplicate found
                }

                // Pop the opening parenthesis '('
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // No duplicates found
        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        String expr1 = "((a+b))";          // duplicate
        String expr2 = "(a+(b)/c)";        // not duplicate
        String expr3 = "(a+b*(c-d))";      // not duplicate
        String expr4 = "(((x)))";          // duplicate

        System.out.println(expr1 + " → " + hasDuplicateParentheses(expr1));  // true
        System.out.println(expr2 + " → " + hasDuplicateParentheses(expr2));  // false
        System.out.println(expr3 + " → " + hasDuplicateParentheses(expr3));  // false
        System.out.println(expr4 + " → " + hasDuplicateParentheses(expr4));  // true
    }
}
