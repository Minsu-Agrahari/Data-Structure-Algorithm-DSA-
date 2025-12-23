import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {

    // Function to reverse the queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        // Base case: If the queue is empty, return
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element of the queue
        int front = queue.poll();

        // Reverse the remaining queue
        reverseQueue(queue);

        // Add the front element back to the queue (now it goes to the rear)
        queue.offer(front);
    }

    // Function to display the queue
    public static void displayQueue(Queue<Integer> queue) {
        System.out.print("Queue: ");
        for (int element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Initialize a queue and add some elements
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        // Display the original queue
        System.out.print("Original ");
        displayQueue(queue);

        // Reverse the queue
        reverseQueue(queue);

        // Display the reversed queue
        System.out.print("Reversed ");
        displayQueue(queue);
    }
}
