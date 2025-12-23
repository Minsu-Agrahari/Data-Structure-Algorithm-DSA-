import java.util.ArrayDeque;
import java.util.Queue;

public class QueueUsingArrayDeque {
    public static void main(String[] args) {
        // Create a Queue using ArrayDeque (internally uses array)
        Queue<Integer> queue = new ArrayDeque<>();

        // 1. Enqueue: Add elements to the queue (using offer() and add())
        queue.offer(10);   // Offer method to add
        queue.add(20);     // Add method to add
        queue.offer(30);   // Offer method to add
        queue.add(40);     // Add method to add

        System.out.println("Queue after enqueuing (offer and add): " + queue);

        // 2. Peek: Get the front element without removing (using peek())
        System.out.println("Front element (peek): " + queue.peek());

        // 3. Dequeue: Remove elements from the queue (using poll() and remove())
        System.out.println("Dequeued (poll): " + queue.poll());  // Removes 10
        System.out.println("Queue after polling: " + queue);

        System.out.println("Dequeued (remove): " + queue.remove()); // Removes 20
        System.out.println("Queue after removing: " + queue);

        // 4. Check if the queue is empty (using isEmpty())
        System.out.println("Is queue empty? " + queue.isEmpty());  // Should return false

        // 5. Size of the queue (using size())
        System.out.println("Queue size: " + queue.size()); // Should return 2

        // 6. Peek again (using peek())
        System.out.println("Front element after dequeue (peek): " + queue.peek());

        // 7. Poll again (using poll())
        System.out.println("Dequeued (poll): " + queue.poll()); // Removes 30
        System.out.println("Queue after polling: " + queue);

        // 8. Check if the queue is empty after removing all elements
        System.out.println("Is queue empty after removing all elements? " + queue.isEmpty()); // Should return true

        // 9. Attempt to peek on empty queue (peek will return null)
        System.out.println("Peek on empty queue: " + queue.peek()); // Should return null

        // 10. Attempt to remove from empty queue (remove will throw NoSuchElementException)
        try {
            System.out.println("Removing from empty queue: " + queue.remove());
        } catch (Exception e) {
            System.out.println("Error: " + e); // Will print exception message
        }

        // 11. Offer method on an empty queue (will return true)
        System.out.println("Offering an element to empty queue: " + queue.offer(50)); // Should return true
        System.out.println("Queue after offering: " + queue);
    }
}
