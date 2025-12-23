import java.util.Stack;

public class PushBottomWithTempStack {

    // Function to push an element at the bottom using a temporary stack
    static void pushAtBottom(Stack<Integer> stack, int data) {
        // Temporary stack to hold elements
        Stack<Integer> tempStack = new Stack<>();

        // Step 1: Move all elements from original stack to tempStack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Step 2: Push the new element to the now-empty original stack
        stack.push(data);

        // Step 3: Move all elements back from tempStack to original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Initial stack elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original Stack: " + stack); // [10, 20, 30]

        // Push 5 at the bottom
        pushAtBottom(stack, 5);

        System.out.println("Stack after pushing 5 at bottom: " + stack); // [5, 10, 20, 30]
    }
}
