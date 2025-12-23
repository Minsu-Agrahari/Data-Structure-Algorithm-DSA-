/**
 * Question :- 
 * 
 * Given a Binary Tree and two node values (n1 and n2), find the Lowest Common Ancestor (LCA) of the two nodes.
 * The Lowest Common Ancestor of two nodes n1 and n2 is defined as the lowest node in the tree that has both n1 and n2 as descendants.
 * Note: A node can be a descendant of itself.
 *
 * Approach (Optimized Recursive Approach):-
 * 
 * - Traverse the tree recursively starting from the root.
 * - If the current node is null, return null.
 * - If the current node matches either n1 or n2, return that node.
 * - Recursively search for n1 and n2 in the left and right subtrees.
 * - If both the left and right recursive calls return non-null values, it means
 *   n1 and n2 are found in different subtrees, so the current node is their LCA.
 * - If only one of them is non-null, return that (propagate the found node up).
 *
 * Time Complexity: O(N), where N is the number of nodes in the binary tree.
 * Space Complexity: O(H), where H is the height of the binary tree (due to recursion stack).
 */

 public class OptimizedLCA {

    // Definition of a Binary Tree Node
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            this.data = value;
            left = right = null;
        }
    }

    /**
     * Function to find the Lowest Common Ancestor (LCA) of two given nodes in a Binary Tree
     * @param root Root node of the binary tree
     * @param n1 First node value
     * @param n2 Second node value
     * @return The node representing the LCA, or null if either n1 or n2 is not present
    */

    static Node findLCA(Node root, int n1, int n2) {
        // Base case: if tree is empty
        if (root == null) return null;

        // If either n1 or n2 matches the current node, return the current node
        if (root.data == n1 || root.data == n2) return root;

        // Recursively find LCA in left and right subtrees
        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        // if left subtress ---> vaild value but the right subtree ---> null
        if(leftLCA != null && rightLCA == null){
            return leftLCA;
        }

        // if my right subtress ---> vaild value but the left subtree ---> null
        if(leftLCA == null && rightLCA != null){
            return rightLCA;
        }

        // If both left and right are non-null, current node is the LCA
        if (leftLCA != null && rightLCA != null) 
            return root;
        
        // 🔴 Missing case handled here: if both are null
        return null;
    }

    public static void main(String[] args) {
        /*
         * Constructing the following binary tree:
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

        // Define the two node values for which LCA is to be found
        int n1 = 4, n2 = 6;

        // Find the LCA
        Node lca = findLCA(root, n1, n2);

        // Print the result
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}
