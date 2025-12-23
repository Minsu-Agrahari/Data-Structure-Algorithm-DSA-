/*
 *       L(1) → L(2) → L(3) → L(4) → ... → L(n-1) → L(n)
 * You need to rearrange it in a zig-zag pattern like:
 *       (1) → L(n) → L(2) → L(n-1) → L(3) → L(n-2) → ...
 * This means:
        - Take the first node from the beginning.
        - Then the last node.

        Then the second node, then second last, and so on.
* Steps to Solve:
        - Find the middle of the linked list.
        - Reverse the second half of the list.
* Merge the two halves alternately (one from start, one from end).
 */

import java.util.LinkedList;

public class ZigZagUsingJCF {

    public static LinkedList<Integer> zigZagReorder(LinkedList<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();

        int start = 0;
        int end = list.size() - 1;

        boolean turn = true; // true → take from front, false → take from end

        while (start <= end) {
            if (turn) {
                result.add(list.get(start));
                start++;
            } else {
                result.add(list.get(end));
                end--;
            }
            turn = !turn; // flip turn
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>();

        // Inserting values
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        inputList.add(6);

        System.out.println("Original List: " + inputList);

        LinkedList<Integer> zigZagList = zigZagReorder(inputList);

        System.out.println("Zig-Zag Reordered List: " + zigZagList);
    }
}
