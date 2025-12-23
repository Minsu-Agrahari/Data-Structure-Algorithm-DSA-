import java.util.Stack; // Import Stack class from the java.util package

public class ReverseStringUsingStack {
    
    // Method to reverse a string using Stack
    public static String reverseString(String str) {
        // Step 1: Create a Stack to hold the characters of the string
        Stack<Character> stack = new Stack<>();

        // Step 2: Push each character of the string onto the stack
        // Time complexity: O(n), where n is the length of the string
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i)); // Push character onto stack
        }

        // Step 3: Pop characters from the stack and form the reversed string
        // Time complexity: O(n), where n is the length of the string
        StringBuilder reversedStr = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedStr.append(stack.pop()); // Pop character from stack and append to result
        }

        // Step 4: Return the reversed string
        // Time complexity: O(n) for StringBuilder append operations
        return reversedStr.toString();
    }

    public static void main(String[] args) {
        // Sample input string
        String input = "Hello, World!";
        
        // Call the reverseString method and print the result
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }
}
