/*
Operation :-
    Search
    Insert
    Traverse
    Delete
    Complexity
 */

package LinkedList.DoublyLinkedList;

import java.util.Scanner;

public class DoublyLinkedList {
    static class Node{
        Node prev;
        int val;
        Node next;

        public Node(int val) {
            this.prev = null;
            this.val = val;
            this.next = null;
        }
    }

    Node head;

    void create_DLL(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Value :- ");
        head = new Node(in.nextInt());
        Node curr = head;

        char ch;
        do{

            System.out.print("Do you want to continue (y/n) :- ");
            ch = in.next().charAt(0);

            if(ch == 'y' || ch == 'Y'){
                // creating new node
                System.out.print("Enter the Value :- ");
                Node newNode = new Node(in.nextInt());

                // establishing the connection
                curr.next = newNode;
                newNode.prev = curr;

                // moving the curr to next node
                curr = newNode;
                System.out.println("\t\t\t\tInsertion successfull ... \n");
            }
        }while(ch == 'Y' || ch == 'y');
    }
    void insert(int idx, int elem){
        Node newNode = new Node(elem);

        // Case 1: DLL is empty
        if(head == null){
            head = newNode;
            System.out.println("\n\t\t\t\tInsertion Successful .. ");
            return;
        }

        // Case 2: insertion at first
        if(idx == 0){
            newNode.next = head;
            head.prev = newNode;

            head = newNode;
            System.out.println("\n\t\t\t\tInsertion Successful .. ");
            return;
        }

        // Case 3: in middle or end
        Node curr = head;
        for(int i=0; i<(idx-1); i++){
            curr = curr.next;
        }

        Node superNext = curr.next;
        curr.next = newNode;
        newNode.prev = curr;

        newNode.next = superNext;
        superNext.prev = newNode;

        System.out.println("\n\t\t\t\tInsertion Successful .. ");
    }
    void delete(int idx){
        // DLL is Empty
        if(head == null || idx<0 || idx>size()){
            System.out.println("Deletion Not Possible ... ");
            return;
        }

        // Case 1: remove 1st element
        if(idx == 0){
            head = head.next;
            head.prev = null;

            System.out.println("Deletion Successful");
            return;
        }

        // Case 2: Deletion last or mid
        Node curr = head;
        for(int i=0; i<(idx-1); i++){
            curr = curr.next;
        }

        if(curr.next != null && curr.next.next != null){
            Node superNext = curr.next.next;

            curr.next = superNext;
            superNext.prev = curr;
        }else{
            curr.next = null;
        }

        System.out.println("Deletion Successful");
    }
    void display(){
        // base case
        if(head == null){
            System.out.println("\t\t\t\tNo Element Found !!");
            return;
        }

        Node curr = head;

        System.out.print("D_LL Element :- ");
        while (curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    boolean search(int val){
        if(head == null) return false;

        Node curr = head;
        while(curr != null){
            if(curr.val == val) return true;
            curr = curr.next;
        }

        return false;
    }
    int size(){
        // base case
        if(head == null) return 0;

        int size = 0;

        Node curr = head;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }
    void reverse(){
        //  Empty list or single node
        if(head == null ||head.next == null) return;

        Node curr = head;
        Node temp = null;

        while(curr != null){

            // swap the next and prev
            temp = curr.next;
            curr.prev = curr.next;
            curr.next = temp;

            // move to next node
            curr = curr.prev;
        }

        // update the head
        if(temp != null){
            head = temp.prev;
        }
    }

    static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.create_DLL();

        System.out.println("\t\t\t\t-- Insertion Operation -- ");
        dll.insert(-9, 2); dll.display();
        dll.insert(0, 100); dll.display();
        dll.insert(2, 55); dll.display();
        dll.insert(dll.size()-1, 99); dll.display();

        System.out.println("\t\t\t\t-- Deletion Operation -- ");
        dll.delete(-9); dll.display();
        dll.delete(0); dll.display();
        dll.delete(2); dll.display();
        dll.delete(dll.size()-1); dll.display();

        System.out.println("\nElement Found :- "+dll.search(4));

        dll.display();
        dll.reverse();
        dll.display();
    }
}
