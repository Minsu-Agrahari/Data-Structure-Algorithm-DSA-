/*
 * Title: Build a Binary Search Tree (BST) and perform Inorder Traversal
 * 
 * Description:
 * - This program builds a Binary Search Tree (BST) from an array of integers.
 * - It uses a recursive method to insert each node into the correct position.
 * - After building the tree, it prints the elements using inorder traversal (Left, Root, Right),
 *   which prints the values in **sorted order** for a BST.
 * 
 * Time Complexity:
 * - Insertion (treeBuilder):
 *   -> Worst Case: O(N^2) [when BST becomes skewed, like inserting sorted data]
 *   -> Average Case: O(N log N)
 * - Inorder Traversal: O(N)
 * - Total Time Complexity:
 *   -> Worst Case: O(N^2)
 *   -> Average Case: O(N log N)
 * 
 * Space Complexity:
 * - Due to recursion in treeBuilder and inorder traversal:
 *   -> Worst Case: O(N)
 *   -> Average Case: O(log N)
 * - For storing nodes: O(N)
 * - Total Space Complexity: O(N)
 */

 public class Build_BST {

    // Node class represents a single node in the BST
    public static class Node {
        int data;       // value stored in the node
        Node left;      // reference to left child
        Node right;     // reference to right child

        // Constructor to initialize node with a value
        Node(int val) {
            this.data = val;
            left = right = null;
        }
    }

    // Method to build the BST by inserting a value in the correct position
    public static Node treeBuilder(Node root, int val) {
        // If the tree is empty, create a new node as root
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // Recursively insert in the right subtree if value is greater
        if (root.data < val) {
            root.right = treeBuilder(root.right, val);
        }

        // Recursively insert in the left subtree if value is smaller
        if (root.data > val) {
            root.left = treeBuilder(root.left, val);
        }

        return root;
    }

    // Inorder traversal of BST (Left -> Root -> Right)
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);            // Traverse left subtree
        System.out.print(root.data + " "); // Print current node
        inorder(root.right);           // Traverse right subtree
    }

    // Main method to run the program
    public static void main(String[] args) {
        int[] nodes = {51, 1, 3, 114, 2, 7}; // Input array of values to insert into BST
        Node root = null;

        // Build BST from input array
        for (int elem : nodes) {
            root = treeBuilder(root, elem);
        }

        // Print BST in inorder (which will be sorted order)
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}
