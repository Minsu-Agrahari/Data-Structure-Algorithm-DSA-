// Node class for Doubly Linked List
class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    DoublyNode head;

    // Function to insert node at end
    public void insertAtEnd(int value) {
        DoublyNode newNode = new DoublyNode(value);

        if (head == null) {
            head = newNode;
            return;
        }

        DoublyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Function to reverse the Doubly Linked List
    public void reverse() {
        DoublyNode current = head;
        DoublyNode temp = null;

        // Traverse the list and swap next and prev for each node
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev; // move to next node (which is previous in original list)
        }

        // After the loop, temp will be at the old head’s previous node (new head)
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Function to print the list forward
    public void printList() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Inserting nodes
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);

        System.out.println("Original DLL:");
        dll.printList();  // Output: 1 ⇄ 2 ⇄ 3 ⇄ 4 ⇄ 5 ⇄ null

        // Reversing the list
        dll.reverse();

        System.out.println("Reversed DLL:");
        dll.printList();  // Output: 5 ⇄ 4 ⇄ 3 ⇄ 2 ⇄ 1 ⇄ null
    }
}
