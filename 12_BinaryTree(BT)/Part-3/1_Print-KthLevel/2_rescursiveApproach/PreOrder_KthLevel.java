/*
 * recursive Approach
 * --> Pre Order Travesal
 */

import java.util.Scanner;

public class PreOrder_KthLevel {
     
    // custom data structure
    static class Node{
        int data;
        Node left;
        Node right;
 
        Node(int value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    static class PreOrder_Traversal{
        // static int currLevel = 0;
        void Kth_Level(Node root, int level, int currLevel){
            if(root == null || level < currLevel){
                return;
            }

            if(currLevel == level){
                System.out.print(root.data + " ");
            }

            Kth_Level(root.left, level, currLevel+1);
            Kth_Level(root.right, level, currLevel+1);
            // else if(currLevel > level) System.out.println("Better luchi next time :-(");

            // currLevel++;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        /*
         *            1
         *          /   \
         *         2     3
         *        / \   / \
         *       4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Enter the level :- ");
        int level = in.nextInt();

        PreOrder_Traversal obj = new PreOrder_Traversal();
        obj.Kth_Level(root, level, 0);
    }
}