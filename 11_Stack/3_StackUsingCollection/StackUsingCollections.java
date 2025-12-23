import java.util.Stack;

public class StackUsingCollections {

    public static void main(String[] args) {

        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Stack (top → bottom): " + stack); // [10, 20, 30]

        // Peek at the top element
        System.out.println("Top element (peek): " + stack.peek()); // 30

        // Pop the top element
        System.out.println("Popped element: " + stack.pop()); // 30

        // Display stack after pop
        System.out.println("Stack after pop: " + stack); // [10, 20]

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Check stack size
        System.out.println("Stack size: " + stack.size()); // 2
    }
}
