import java.util.Deque;
import java.util.LinkedList;

public class QueueUsingDeque {

    // Inner class to implement Queue using Deque
    static class Queue<T> {
        private Deque<T> deque;

        // Constructor to initialize the Deque
        public Queue() {
            deque = new LinkedList<>();
        }

        // Enqueue operation: Add element to the end of the queue (deque)
        public void enqueue(T element) {
            deque.addLast(element);
        }

        // Dequeue operation: Remove element from the front of the queue (deque)
        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return deque.removeFirst();
        }

        // Peek the front element of the queue
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return deque.peekFirst();
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        // Display the queue (contents of deque)
        public void display() {
            System.out.println("Queue: " + deque);
        }
    }

    public static void main(String[] args) {
        // Create a queue of integers
        Queue<Integer> queue = new Queue<>();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue after enqueue operations
        queue.display();

        // Peek the front element
        System.out.println("Front element (peek): " + queue.peek());

        // Dequeue elements from the queue
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        // Display the queue after dequeue operations
        queue.display();

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
