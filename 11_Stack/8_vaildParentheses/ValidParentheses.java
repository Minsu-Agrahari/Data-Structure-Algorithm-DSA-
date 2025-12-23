/*
 * ValidParentheses.java
 * This program checks if a string containing parentheses is valid.
 */
import java.util.Stack;

public class ValidParentheses {

    // Function to check if the parentheses in the string are valid
    public static boolean isValid(String s) {
        // Create a stack to keep track of opening parentheses
        Stack<Character> stack = new Stack<>();

        // Traverse through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the character is an opening parenthesis, push it onto the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // If the character is a closing parenthesis
            else if (c == ')' || c == ']' || c == '}') {
                // Check if the stack is empty (no opening parenthesis to match)
                // or if the top of the stack does not match the corresponding opening parenthesis
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // If the stack is empty, it means all parentheses were matched
        return stack.isEmpty();
    }

    // Helper function to check if the opening and closing parentheses are a matching pair
    public static boolean isMatchingPair(char open, char close) {
        // Check if the pair is a valid one: () or [] or {}
        return (open == '(' && close == ')') || 
               (open == '[' && close == ']') || 
               (open == '{' && close == '}');
    }

    // Main method to test the isValid function
    public static void main(String[] args) {
        // Example test cases
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("{[]}"));      // true
    }
}
