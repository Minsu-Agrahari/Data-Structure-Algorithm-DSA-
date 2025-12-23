import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {
        // Create a Deque using LinkedList
        Deque<Integer> deque = new LinkedList<>();
        
        // Add elements to the front of the deque
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);

        // Add elements to the end of the deque
        deque.addLast(40);
        deque.addLast(50);
        
        // Display the current deque
        System.out.println("Deque after adding elements: " + deque);
        
        // Remove elements from the front
        int frontElement = deque.removeFirst();
        System.out.println("Removed from front: " + frontElement);
        
        // Remove elements from the end
        int rearElement = deque.removeLast();
        System.out.println("Removed from rear: " + rearElement);
        
        // Peek the first element
        int peekFront = deque.peekFirst();
        System.out.println("First element (peek): " + peekFront);
        
        // Peek the last element
        int peekRear = deque.peekLast();
        System.out.println("Last element (peek): " + peekRear);
        
        // Display the deque after removal and peeking
        System.out.println("Deque after removals and peeking: " + deque);
    }
}
