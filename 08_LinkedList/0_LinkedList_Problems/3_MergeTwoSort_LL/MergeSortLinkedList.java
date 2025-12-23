// Node class to represent each element of the linked list

/*
 * Merge Sort on a Linked List — a powerful algorithm to sort a linked list in O(n log n) time.
 * This is different from array merge sort because:
 * Linked lists don’t support random access.
 * We need to split using slow and fast pointers.
 * Merging is done by rearranging pointers (no extra array used).
 
    Step    |                Explanation                                             |
    ---------------------------------------------------------------------------------|
    Split   | Use slow and fast pointer to find middle node                          |
    Sort    | Recursively sort the two halves                                        |
    Merge   | Use a dummy node to merge two sorted lists into one                    |
    Time    | O(n log n) — best for linked lists                                     |
    Space   | O(log n) due to recursion (stack frames), not extra memory for nodes   |
    ----------------------------------------------------------------------------------|
 * Merge sort is stable and works well with linked lists.
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortLinkedList {

    // Function to perform merge sort on the linked list
    public static Node mergeSort(Node head) {
        // Base case: if list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves using slow and fast pointer
        Node middle = getMiddleNode(head);    // middle node
        Node nextOfMiddle = middle.next;      // second half starts from here
        middle.next = null;                   // break the list into two halves

        // Step 2: Recursively sort both halves
        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(nextOfMiddle);

        // Step 3: Merge the two sorted halves
        return mergeTwoSortedLists(leftSorted, rightSorted);
    }

    // Helper function to get the middle node of the list
    public static Node getMiddleNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to merge two sorted linked lists
    public static Node mergeTwoSortedLists(Node list1, Node list2) {
        // Dummy node to start the merged list
        Node dummyNode = new Node(-1);
        Node tail = dummyNode;

        // Compare and merge nodes from both lists
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Add remaining nodes from either list
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummyNode.next;  // Head of the merged list
    }

    // Utility function to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test merge sort
    public static void main(String[] args) {
        // Creating an unsorted linked list: 4 → 2 → 5 → 1 → 3
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(3);

        System.out.println("Original Linked List:");
        printList(head);

        // Apply merge sort
        head = mergeSort(head);

        System.out.println("Sorted Linked List:");
        printList(head);
    }
}
