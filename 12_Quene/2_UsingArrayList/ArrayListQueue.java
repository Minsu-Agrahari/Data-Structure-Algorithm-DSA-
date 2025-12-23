import java.util.ArrayList;

public class ArrayListQueue {
    ArrayList<Integer> queue;  // ArrayList to hold the queue elements

    // Constructor to initialize the queue
    public ArrayListQueue() {
        queue = new ArrayList<>();
    }

    // Enqueue: Add element at the end of the queue
    public void enqueue(int data) {
        queue.add(data);  // add at the end (rear)
        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removed = queue.remove(0);  // remove from the front
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek: View the front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return queue.get(0);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Queue: " + queue);
    }

    // Main method to test the queue
    public static void main(String[] args) {
        ArrayListQueue q = new ArrayListQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();  // Output: [10, 20, 30]

        q.dequeue();  // Removes 10
        q.display();  // Output: [20, 30]

        System.out.println("Front element is: " + q.peek());  // Output: 20
    }
}
