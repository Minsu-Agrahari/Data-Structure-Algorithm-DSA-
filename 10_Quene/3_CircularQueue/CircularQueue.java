public class CircularQueue {
    int[] queue;        // Array to store elements
    int front;          // Points to front element
    int rear;           // Points to last element
    int size;           // Current number of elements
    int capacity;       // Maximum size of queue

    // Constructor
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue: Add element at rear
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }

        // Move rear forward in circular way
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove element from front
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

    // Peek: Return front element without removing
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

    // Main method for testing
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();  // Queue: 10 20 30 40 50

        cq.dequeue();
        cq.dequeue();

        cq.display();  // Queue: 30 40 50

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display();  // Queue: 30 40 50 60 70

        System.out.println("Front element is: " + cq.peek());  // 30
    }
}
