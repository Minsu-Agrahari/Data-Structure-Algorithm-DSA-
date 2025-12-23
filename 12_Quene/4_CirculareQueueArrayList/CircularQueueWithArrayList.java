import java.util.ArrayList;

public class CircularQueueWithArrayList {
    private ArrayList<Integer> queue; // To store the elements
    private int front;                // Points to front element
    private int rear;                 // Points to last inserted element
    private int size;                 // Current number of elements
    private int capacity;             // Fixed capacity

    // Constructor
    public CircularQueueWithArrayList(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
        this.front = 0;
        this.rear = -1;
        this.size = 0;

        // Initialize the list with 'null' to set size
        for (int i = 0; i < capacity; i++) {
            queue.add(null); // Placeholder values
        }
    }

    // Enqueue: Add element at rear
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        // Move rear forward in circular way
        rear = (rear + 1) % capacity;
        queue.set(rear, data); // Set value at calculated index
        size++;

        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove element from front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removed = queue.get(front);
        queue.set(front, null); // Optional: Clear the removed slot
        front = (front + 1) % capacity;
        size--;

        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek: Return front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return queue.get(front);
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue.get(index) + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        CircularQueueWithArrayList cq = new CircularQueueWithArrayList(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display(); // Output: 10 20 30 40 50

        cq.dequeue(); // Removes 10
        cq.dequeue(); // Removes 20

        cq.display(); // Output: 30 40 50

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display(); // Output: 30 40 50 60 70

        System.out.println("Front element is: " + cq.peek()); // Output: 30
    }
}
