import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {

    // Inner class to implement Stack using Deque
    static class Stack<T> {
        private Deque<T> deque;

        // Constructor to initialize the Deque
        public Stack() {
            deque = new LinkedList<>();
        }

        // Push element onto the stack (add to the front of deque)
        public void push(T element) {
            deque.addFirst(element);
        }

        // Pop element from the stack (remove from the front of deque)
        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return deque.removeFirst();
        }

        // Peek the top element of the stack (view the front element of deque)
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return deque.peekFirst();
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Display the stack (contents of deque)
        public void display() {
            System.out.println("Stack: " + deque);
        }
    }

    public static void main(String[] args) {
        // Create a stack of integers
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack after pushing elements
        stack.display();

        // Peek the top element
        System.out.println("Top element (peek): " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Display the stack after popping elements
        stack.display();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
