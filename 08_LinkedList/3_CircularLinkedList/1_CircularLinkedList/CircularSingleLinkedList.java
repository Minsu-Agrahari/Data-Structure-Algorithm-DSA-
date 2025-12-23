/*
Operation :-
     Method          Complexity
    Search   -->
    Insert   -->
    Traverse -->
    Delete   -->
    reverse  -->
 */

package LinkedList.CircularLinkedList.CircularLinkedList;

import java.util.Scanner;

public class CircularSingleLinkedList {
    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    void create(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Value :- ");
        head = new Node(in.nextInt());

        Node curr = head;
        Node newNode;

        char ch;
        do{
            System.out.print("Do you want to continue (y/n) :- ");
            ch = in.next().charAt(0);

            if(ch == 'y' || ch == 'Y'){

                System.out.print("Enter the Value :- ");
                newNode = new Node(in.nextInt());
                curr.next = newNode;

                curr = newNode;
            }

        }while(ch == 'y' || ch == 'Y');

        curr.next = head;
    }
    void insert(int idx, int val){

        if(idx<0 || idx>size()){
            System.out.println("\nInsertion not Possible ... ");
            return;
        }

        Node newNode = new Node(val);

        // case 1: Empty List
        if(head == null){
            newNode.next = newNode;
            head = newNode;
            System.out.print("--- Insertion Successfull !!");
            return;
        }

        // case 2: Insert at start
        if(idx == 0){

            System.out.println("in");
            Node curr = head;

            // find last node
            while(curr.next != head){
                curr = curr.next;
            }

            // establishing connection
            newNode.next = head;
            curr.next = newNode;
            head = newNode;
            System.out.print("--- Insertion Successfull !!");

            return;
        }

        // Case 3: Insert at middle or end
        Node curr = head;
        for(int i=0; i<idx-1; i++){
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
        System.out.print("--- Insertion Successfull !!");
    }
    void delete(int idx){
        if(head == null || idx<0 || idx > size()){
            System.out.println("-- Deletion not possible");
            return;
        }

        // case 1: deleting the head
        if(idx == 0){
            Node curr = head;

            // find the last node
            while(curr.next != head){
                curr = curr.next;
            }

            head = head.next;
            curr.next = head;

            System.out.println("Deletion Successful ... ");
            return;
        }

        // case 2: delete mid or end node
        Node curr = head;
        for(int i=0; i<(idx-1); i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
    }
    boolean search(int val){
        Node curr = head;
        while (curr.next != head){
            if(curr.val == val) return true;
            curr = curr.next;
        }
        return false;
    }
    void display(){
        Node curr = head;

        System.out.print("\nLinkedList Element :- " + curr.val + " ");
        curr = curr.next;

        while(curr != head){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
    void reverse(){
        // case 1: Empty list or single node
        if(head == null || head.next == head) return;

        Node prev = null;
        Node curr = head;
        Node next;

        Node last = head;

        do {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }while(curr != head);

        last.next = prev;
        head = prev;
    }
    boolean cycleDetection(){
        Node fast = head.next;
        Node slow = head;

        while(fast != null && fast.next != null){
            if(fast == slow) return true;

            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
    int size(){
        if(head == null) return 0;

        Node curr = head;
        int size = 1;

        while(curr.next != head){
            size++;
            curr = curr.next;
        }
        return size;
    }

    static void main(String[] args) {
        CircularSingleLinkedList cll = new CircularSingleLinkedList();

        cll.create();

        cll.display();

        cll.insert(-1, 33); cll.display();
        cll.insert(0, 0); cll.display(); // first
        cll.insert(7, 99); cll.display(); // last
        cll.insert(3, 33); cll.display(); // middle

        if(cll.search(33)) System.out.println("\nElement Found");
            else
        System.out.println("\nElement Not Found !");

        System.out.println("Cycle detected :- "+ cll.cycleDetection());

        cll.delete(-1);
        cll.delete(0); cll.display();
        cll.delete(7); cll.display();
        cll.delete(3); cll.display();

        System.out.print("\nOriginal CLL --> "); cll.display();
        System.out.print("\nReverse CLL --> "); cll.reverse(); cll.display();
    }
}
