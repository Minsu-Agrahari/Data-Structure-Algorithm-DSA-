/*
 * Iterative Approach
 * --> Level Order Travesal
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelTraversal_KthLevel {
    
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

    static class LevelOrderTraversal{
        void levelOrder(Node root, int k){
            
            if(root == null) return;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int level = 0;

            // Node []temp = new Node[10]; 
            // int idx = 1;

            while (!q.isEmpty()){
                int size = q.size();

                // System.out.print("size :- " + size + "\n");
                // if(!q.isEmpty()){
                //     System.out.println(idx + "---------------element in the queue ---------------");
                //     for(int i=0; i<size; i++){
                //         temp[i] = q.remove();
                //         System.out.print(temp[i].data+ " ");
                        
                //     }
                //     System.out.println(idx + "\n -----------------------------------------------------");
                // }
                
                // for(int i=0; i<size; i++){
                //     q.add(temp[i]);
                // }


                // if current level is the desired level
                if(level == k){  
                    for(int i=0; i<size; i++){
                        System.out.print(q.remove().data+ " ");
                    }
                    System.out.println();
                    return;
                }

                // Traverse to next level
                for(int i=0; i<size; i++){
                    Node curr = q.remove();
                    // System.out.println("======================================= " + curr.data + " ") ;
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }

                level++;
                // idx ++;
            }

            // if k is more than tree height
            System.out.println("Level " + k + " does not exist. ");
        }
    }

    // main function 
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

        System.out.println("Enter the kth level :- " );
        int k = in.nextInt();

        LevelOrderTraversal obj = new LevelOrderTraversal();
        obj.levelOrder(root, k);
    }
}
