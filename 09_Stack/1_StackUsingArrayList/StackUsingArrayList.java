import java.util.ArrayList;

// Stack implementation using ArrayList
public class StackUsingArrayList {

    // ArrayList to store stack elements (default access, not private)
    ArrayList<Integer> stackList;

    // Constructor to initialize the stack
    StackUsingArrayList() {
        stackList = new ArrayList<>();
    }

    // Push method: adds element to the top of stack
    void push(int data) {
        stackList.add(data); // Add element at the end (top of stack)
    }

    // Pop method: removes and returns top element of stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1; // Or you could throw an exception
        }
        return stackList.remove(stackList.size() - 1); // Remove last element
    }

    // Peek method: returns top element without removing it
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1;
        }
        return stackList.get(stackList.size() - 1); // Get last element
    }

    // Check if the stack is empty
    boolean isEmpty() {
        return stackList.isEmpty();
    }

    // Return current size of the stack
    int size() {
        return stackList.size();
    }

    // Display stack elements from bottom to top
    void display() {
        System.out.println("Stack (bottom → top): " + stackList);
    }

    // Main method to test the stack
    public static void main(String[] args) {
        StackUsingArrayList stack = new StackUsingArrayList();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        stack.display();  // Output: [5, 10, 15]

        System.out.println("Top element (peek): " + stack.peek()); // Output: 15

        System.out.println("Popped element: " + stack.pop());      // Output: 15

        stack.display();  // Output: [5, 10]

        System.out.println("Stack is empty? " + stack.isEmpty());  // Output: false
    }
}
