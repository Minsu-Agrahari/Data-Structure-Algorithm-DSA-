// Node class for LinkedList
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue implementation using LinkedList
public class QueueUsingLinkedList {
    private Node front;  // Points to front element of queue
    private Node rear;   // Points to last element of queue

    public QueueUsingLinkedList() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue: Add element at the rear
    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (rear == null) {
            // If queue is empty, both front and rear are the same
            front = rear = newNode;
        } else {
            rear.next = newNode; // Link new node at the end
            rear = newNode;      // Update rear pointer
        }

        System.out.println("Enqueued: " + data);
    }

    // Dequeue: Remove element from the front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }

        int removedData = front.data;
        front = front.next; // Move front to next node

        // If queue becomes empty
        if (front == null) {
            rear = null;
        }

        System.out.println("Dequeued: " + removedData);
        return removedData;
    }

    // Peek: View front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();  // Output: Queue: 10 20 30

        queue.dequeue();  // Removes 10
        queue.display();  // Output: Queue: 20 30

        System.out.println("Front element: " + queue.peek()); // Output: 20
    }
}
