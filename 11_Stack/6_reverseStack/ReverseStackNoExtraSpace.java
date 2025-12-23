import java.util.Stack; // Import Stack class from java.util package

public class ReverseStackNoExtraSpace {
    
    // Method to reverse the stack
    public static void reverseStack(Stack<Integer> stack) {
        // Base case: If stack is empty, return
        if (stack.isEmpty()) {
            return;
        }
        
        // Step 1: Pop the top element of the stack
        int top = stack.pop();
        
        // Step 2: Recursively reverse the remaining stack
        reverseStack(stack);
        
        // Step 3: Insert the popped element at the bottom of the stack
        insertAtBottom(stack, top);
    }
    
    // Helper method to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: If stack is empty, simply push the element
        if (stack.isEmpty()) {
            stack.push(element);
        } else {
            // Step 1: Pop the top element
            int top = stack.pop();
            
            // Step 2: Recursively call to reach the bottom
            insertAtBottom(stack, element);
            
            // Step 3: Push the top element back to the stack
            stack.push(top);
        }
    }

    public static void main(String[] args) {
        // Create a stack and add elements to it
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        // Print original stack
        System.out.println("Original Stack: " + stack);
        
        // Call the reverse method
        reverseStack(stack);
        
        // Print reversed stack
        System.out.println("Reversed Stack: " + stack);
    }
}
