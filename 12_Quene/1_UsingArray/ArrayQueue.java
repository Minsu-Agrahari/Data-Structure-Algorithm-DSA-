public class ArrayQueue {
    int[] queue;         // Array to store queue elements
    int front;           // Index of front element
    int rear;            // Index of last element
    int size;            // Current size of the queue
    int capacity;        // Maximum size of the queue

    // Constructor to initialize the queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue: Add element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        // Move rear to next position and insert
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek: Get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return queue[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        q.dequeue();
        q.dequeue();

        q.display();

        System.out.println("Front element is: " + q.peek());
    }
}
