/*
Operation :-
     Method          Complexity
    Search   -->
    Insert   -->
    Traverse -->
    Delete   -->
    reverse  -->
 */

package LinkedList.SinglyLinkedList;

import java.util.Scanner;

public class SingleLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
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

        char ch;
        do{
            System.out.print("Do you want to insert more element (y/n) :- ");
            ch = in.next().charAt(0);

            if(ch == 'Y' || ch == 'y'){
                System.out.print("Enter the Value :- ");
                Node newNode = new Node(in.nextInt());
                curr.next = newNode;
                curr = newNode;
            }
        }while(ch == 'y' || ch == 'Y');
    }
    void display(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    boolean search(int key){
        Node curr = head;
        while(curr != null){
            if(curr.val == key){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
    void insert(int key, int idx){
        if(head == null || idx >= size()) return;

        Node newNode = new Node(key);

        if(idx == 0){ // insertion at first
            newNode.next = head;
            head = newNode;
        }else if(idx < size()){
            Node curr = head;
            while(idx-- > 1){
                curr = curr.next;
            }

            Node prev = curr.next;
            curr.next = newNode;
            newNode.next = prev;
        }
    }
    void delete(int idx){
        if(idx >= size() || idx < 0 || head == null) return;

        if(idx == 0) head = head.next;
        else{
            Node curr = head;
            while(--idx > 0){
                curr = curr.next;
            }
            if(curr.next != null && curr.next.next != null){
                curr.next = curr.next.next;
            }else curr.next = null;
        }
    }
    int size(){
        Node curr = head;
        int size = 0;
        while(curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }
    Node reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
        return prev;
    }

    public static void main(String[] args) {

        SingleLinkedList s = new SingleLinkedList();

        s.create();
        s.display();
        System.out.println(s.search(3));
        System.out.println(s.size());

        System.out.print("\nInsert at 0 :- "); s.insert(55,0); s.display();
        System.out.print("\nInsert at 3 :- "); s.insert(33,3); s.display();
        System.out.print("\nInsert at 6 :- "); s.insert(99,6); s.display();

        System.out.print("\nDelete at 0 :- "); s.delete(0); s.display();
        System.out.print("\nDelete at 4 :- "); s.delete(4); s.display();
        System.out.print("\nDelete at 6 :- "); s.delete(6); s.display();

        System.out.print("Reverse :- "); s.reverse(); s.display();
    }
}
