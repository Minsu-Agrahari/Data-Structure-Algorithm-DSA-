import java.util.*;

public class Delete_Node {

    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            this.data = val;
        }
    }

    public static Node treeBuilder(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data) {
            root.left = treeBuilder(root.left, val);
        } else if (val > root.data) {
            root.right = treeBuilder(root.right, val);
        }

        return root;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data + ", ");
        inOrderTraversal(root.right);
    }

    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            Node successor = findInorderSuccessor(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int val : nodes) {
            root = treeBuilder(root, val);
        }

        System.out.println("Inorder before deletion:");
        inOrderTraversal(root);
        System.out.println();

        root = delete(root, 4); // Important: reassign root if root is deleted

        System.out.println("Inorder after deletion of 4:");
        inOrderTraversal(root);
        System.out.println();
    }
}
