import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> queue1;  // First queue for stack operations
    private Queue<Integer> queue2;  // Second queue for stack operations

    // Constructor to initialize two queues
    public StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 1. Push operation: Insert element onto the stack
    public void push(int data) {
        // Push the new element to queue2
        queue2.offer(data);

        // Move all elements from queue1 to queue2 to maintain stack order
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Swap the names of the two queues to make queue1 the main queue
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        System.out.println("Pushed: " + data);
    }

    // 2. Pop operation: Remove and return the top element of the stack
    public int pop() {
        // If the stack is empty, return -1
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }

        // Pop the front element from queue1 (top of the stack)
        int poppedElement = queue1.poll();
        System.out.println("Popped: " + poppedElement);
        return poppedElement;
    }

    // 3. Peek operation: View the top element without removing it
    public int peek() {
        // If the stack is empty, return -1
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }

        // Return the front element of queue1 (top of the stack)
        return queue1.peek();
    }

    // 4. Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Display the elements of the stack
    public void display() {
        System.out.print("Stack: ");
        for (int element : queue1) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Display the stack
        stack.display();  // Output: Stack: 40 30 20 10 

        // Peek top element
        System.out.println("Top element (peek): " + stack.peek());  // Output: 40

        // Pop elements from the stack
        stack.pop();  // Output: Popped: 40
        stack.display();  // Output: Stack: 30 20 10

        // Push more elements
        stack.push(50);
        stack.push(60);
        stack.display();  // Output: Stack: 60 50 30 20 10

        // Pop remaining elements
        stack.pop();  // Output: Popped: 60
        stack.pop();  // Output: Popped: 50
        stack.display();  // Output: Stack: 30 20 10

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());  // Output: false
    }
}
