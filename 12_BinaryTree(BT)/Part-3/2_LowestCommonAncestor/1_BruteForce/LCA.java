/*
 * --- LOWEST COMMON ANCESTOR (LCA)
 *
 * Problem Statement:-
 * Given a binary tree and two node values n1 and n2, find the Lowest Common Ancestor (LCA).
 * The LCA of two nodes is the deepest (lowest) node that has both n1 and n2 as descendants.
 * Note: A node can be a descendant of itself.
 *
 * Example Input:
 *      n1 = 4, n2 = 6
 *
 * Tree:
 *                1
 *              /   \
 *             2     3
 *            / \   / \
 *           4   5 6   7
 *
 * Output:
 *      1
 *
 * Approach:
 * → This approach stores the paths from the root to both n1 and n2 in separate lists.
 * → Then it compares both paths and returns the last common node before they differ.
 * → If either node is not found in the tree, it returns null.
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H) for recursion stack + O(N) for storing path
 */

 import java.util.ArrayList;
 import java.util.List;
 
 public class LCA {
 
    // Custom Node class representing each node in the binary tree
    static class Node {
        int data;
        Node left, right;
 
        Node(int value) {
            this.data = value;
            left = right = null;
        }
    }
 
    /**
      * Function to store the path from root node to the target node.
      * 
      * @param root   - current root node
      * @param target - value of the node to be found
      * @param path   - ArrayList to store the path
      * @return true  - if path is found, 
      *        false - otherwise
    */

    static boolean getPath(Node root, int target, List<Node> path) {
        if (root == null) return false;
 
        // Add current node to the path --- ArrayList
        path.add(root);
 
        // If current node is the target node
        if (root.data == target) return true;
 
        // Recursively search in left and right subtrees
        if (getPath(root.left, target, path)) return true;
        if (getPath(root.right, target, path)) return true;

        // If not found, backtrack and remove node from path
        path.remove(path.size() - 1);
        return false;
    }
 
    /**
     * Function to find the Lowest Common Ancestor (LCA) of two given nodes.
     * 
     * @param root - root of the binary tree
     * @param n1   - first node value
     * @param n2   - second node value
     * @return Node - the LCA node
     *
    */

    static Node LCA(Node root, int n1, int n2) {
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
 
        // Get paths from root to n1 and n2
        if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
            return null; // One or both nodes not found in the tree :-(
        }
 
        // Compare the paths to find the last common node
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i).data == path2.get(i).data) {
            i++;
        }
 
        return path1.get(i - 1); // Last common node is the LCA
    }
 
    public static void main(String[] args) {
 
        /*
          * Constructing the following binary tree:
          *
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
 
        // Define the two nodes to find LCA for
        int n1 = 4, n2 = 5;
 
        Node lca = LCA(root, n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("LCA not found (one or both nodes are missing)");
        }
    }
}
 