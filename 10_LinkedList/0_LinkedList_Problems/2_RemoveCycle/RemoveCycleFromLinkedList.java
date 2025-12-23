// Node class to represent each element of the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveCycleFromLinkedList {

    // Function to detect and remove a cycle from the linked list
    public static void detectAndRemoveCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect if a cycle exists
        boolean isCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // move slow by 1 step
            fast = fast.next.next;      // move fast by 2 steps

            if (slow == fast) {
                isCycle = true;         // cycle detected
                break;
            }
        }

        if (!isCycle) {
            System.out.println("No cycle found.");
            return;
        }

        // Step 2: Find the start node of the cycle
        slow = head;
        Node prev = null;  // to track the node before the start of the cycle

        while (slow != fast) {
            prev = fast;      // keep track of the previous node of fast
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Break the cycle by setting the 'next' of previous node to null
        prev.next = null;

        System.out.println("Cycle removed successfully.");
    }

    // Utility function to print the linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Step 1: Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // Step 2: Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Step 3: Create a cycle for testing
        node5.next = node3;  // Cycle created: 5 → 3

        // Step 4: Remove cycle
        detectAndRemoveCycle(node1);

        // Step 5: Print the linked list after removing cycle
        printLinkedList(node1);
    }
}
