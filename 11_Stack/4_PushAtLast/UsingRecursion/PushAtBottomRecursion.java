import java.util.Stack;

public class PushAtBottomRecursion {

    // Function to push element at the bottom of the stack using recursion
    static void pushAtBottom(Stack<Integer> stack, int data) {
        // Base case: if stack is empty, push the data
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively call to reach the bottom
        pushAtBottom(stack, data);

        // Step 3: Push the top element back after inserting at bottom
        stack.push(top);
    }

    // Main method to test the code
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements normally
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack); // [10, 20, 30]

        // Push 5 at the bottom of the stack
        pushAtBottom(stack, 5);

        System.out.println("Stack after pushing 5 at bottom: " + stack); // [5, 10, 20, 30]
    }
}
