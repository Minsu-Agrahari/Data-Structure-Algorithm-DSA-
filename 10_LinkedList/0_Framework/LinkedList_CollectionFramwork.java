package LinkedList.Framework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class LinkedList_CollectionFramwork {

    static void main(String[] args) {

        // created a linkedList
        LinkedList<Integer> ll = new LinkedList<>();


        // add elem in linklist
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);

        System.out.println(ll);

        // making linked-list from another COLLECTION FRAMEWORK
        ArrayList<Integer> li = new ArrayList<>(Arrays.asList(1, 2, 3, 45, 6));
        LinkedList<Integer> ll2 = new LinkedList<>(li);
        System.out.println(ll2);

        // add element at a particular index
        ll.add(3, 32);
        System.out.println(ll);

        // update the value at a particular index
        ll.set(3, 43);
        System.out.println(ll);

        // remove value form particular index
        ll.remove(3);
        System.out.println(ll);
    }
}