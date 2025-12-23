/*
 *  Detecting a cycle in a LinkedList is a classic problem — 
 * 
 * We'll use Floyd’s Cycle Detection Algorithm 
 *    --- also called Tortoise and Hare. 
 *    --- It's fast and uses constant space.
 */

 // Node class to represent each element of the linked list
class Node {
    int data;         // Value of the node
    Node next;        // Reference to the next node

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectCycleInLinkedList {

    // Function to check whether a cycle exists in the linked list
    public static boolean hasCycle(Node head) {

        // Step 1: Create two pointers, slow and fast
        Node slowPointer = head;
        Node fastPointer = head;

        // Step 2: Traverse the list with both pointers
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;              // move slow by 1 step
            fastPointer = fastPointer.next.next;         // move fast by 2 steps

            // If they meet, a cycle exists
            if (slowPointer == fastPointer) {
                return true;
            }
        }

        // If loop ends, no cycle found
        return false;
    }

    // Main method to test the code
    public static void main(String[] args) {

        // Step 1: Create nodes
        Node firstNode = new Node(10);
        Node secondNode = new Node(20);
        Node thirdNode = new Node(30);
        Node fourthNode = new Node(40);

        // Step 2: Link nodes together
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        // Uncomment the below line to create a cycle manually
        fourthNode.next = secondNode;

        // Step 3: Call the function and print result
        if (hasCycle(firstNode)) {
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
