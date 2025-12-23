import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> stack1;  // Stack for enqueue operations
    private Stack<Integer> stack2;  // Stack for dequeue operations

    // Constructor to initialize the two stacks
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 1. Enqueue: Add an element to the queue (push to stack1)
    public void enqueue(int data) {
        stack1.push(data);
        System.out.println("Enqueued: " + data);
    }

    // 2. Dequeue: Remove an element from the queue
    public int dequeue() {
        // If both stacks are empty, throw an exception
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Pop from stack2 (this gives the front element of the queue)
        return stack2.pop();
    }

    // 3. Peek: Get the front element without removing it
    public int peek() {
        // If both stacks are empty, return -1
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        // If stack2 is empty, transfer elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // Return the top element of stack2 (front of the queue)
        return stack2.peek();
    }

    // 4. Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Display the elements of the queue
    public void display() {
        System.out.print("Queue: ");
        if (!stack2.isEmpty()) {
            // Display elements in stack2 from top to bottom
            for (int element : stack2) {
                System.out.print(element + " ");
            }
        }
        if (!stack1.isEmpty()) {
            // Display elements in stack1 from bottom to top
            Stack<Integer> tempStack = new Stack<>();
            while (!stack1.isEmpty()) {
                tempStack.push(stack1.pop());
            }
            for (int element : tempStack) {
                System.out.print(element + " ");
            }
            // Restore the original order in stack1
            while (!tempStack.isEmpty()) {
                stack1.push(tempStack.pop());
            }
        }
        System.out.println();
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        // 1. Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // 2. Display the queue
        queue.display();  // Output: Queue: 10 20 30

        // 3. Peek front element
        System.out.println("Front element (peek): " + queue.peek());  // Output: 10

        // 4. Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());  // Output: 10
        queue.display();  // Output: Queue: 20 30

        // 5. Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // 6. Display the queue
        queue.display();  // Output: Queue: 20 30 40 50

        // 7. Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue());  // Output: 20
        System.out.println("Dequeued: " + queue.dequeue());  // Output: 30
        queue.display();  // Output: Queue: 40 50

        // 8. Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: false

        // 9. Dequeue last elements
        System.out.println("Dequeued: " + queue.dequeue());  // Output: 40
        System.out.println("Dequeued: " + queue.dequeue());  // Output: 50
        queue.display();  // Output: Queue: (empty)

        // 10. Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: true
    }
}
