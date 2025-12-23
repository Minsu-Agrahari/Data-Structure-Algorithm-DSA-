import java.util.LinkedList;

// Stack class using LinkedList
public class StackUsingLinkedList {

    // LinkedList to store stack elements (LIFO behavior)
    LinkedList<Integer> stackList;

    // Constructor to initialize the stack
    StackUsingLinkedList() {
        stackList = new LinkedList<>();
    }

    // Method to push (add) an element to the top of the stack
    void push(int data) {
        stackList.addFirst(data); // Add at the beginning (top of the stack)
    }

    // Method to pop (remove) the top element from the stack
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return -1;
        }
        return stackList.removeFirst(); // Remove and return the top element
    }

    // Method to peek (view) the top element without removing it
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return -1;
        }
        return stackList.getFirst(); // Return the top element
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return stackList.isEmpty();
    }

    // Method to get the size of the stack
    int size() {
        return stackList.size();
    }

    // Method to display the stack (top to bottom)
    void display() {
        System.out.println("Stack (top → bottom): " + stackList);
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        stack.display();  // Output: [300, 200, 100]

        System.out.println("Top element (peek): " + stack.peek());  // Output: 300

        System.out.println("Popped element: " + stack.pop());       // Output: 300

        stack.display();  // Output: [200, 100]

        System.out.println("Stack is empty? " + stack.isEmpty());   // Output: false
    }
}
