import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueUsingStack {

    // Function to reverse the queue using a stack
    public static void reverseQueue(Queue<Integer> queue) {
        // Create a stack to help with reversing
        Stack<Integer> stack = new Stack<>();

        // Transfer all elements from the queue to the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Transfer all elements back from the stack to the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
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
