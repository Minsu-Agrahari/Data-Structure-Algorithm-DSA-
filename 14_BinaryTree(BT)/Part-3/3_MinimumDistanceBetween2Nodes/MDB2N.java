public class MDB2N {

    // Node structure for a binary tree
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            this.data = value;
            left = right = null;
        }
    }

    /**
     * Function to find the Lowest Common Ancestor (LCA) of two nodes n1 and n2
     * in a binary tree.
     * 
     * Approach:
     * - If current node is null, return null
     * - If current node matches n1 or n2, return current node
     * - Recursively search in left and right subtrees
     * - If both sides return non-null, current node is LCA
     * - If one side returns non-null, propagate it upwards
     */
    static Node findLCA(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.data == n1 || root.data == n2) return root;

        Node leftLCA = findLCA(root.left, n1, n2);
        Node rightLCA = findLCA(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) return root;

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    /**
     * Function to find the distance from a given root node to a target node `n`.
     * 
     * Approach:
     * - If root is null, return -1 (node not found)
     * - If current node matches the target, return 0
     * - Recursively search in left and right subtrees
     * - If node found in either subtree, return distance + 1
     */
    static int lca_Dist(Node root, int n) {
        if (root == null) return -1;

        if (root.data == n) return 0;

        int leftDist = lca_Dist(root.left, n);
        if (leftDist != -1) return leftDist + 1;

        int rightDist = lca_Dist(root.right, n);
        if (rightDist != -1) return rightDist + 1;

        return -1; // Node not found in either subtree
    }

    /**
     * Function to find the minimum distance between two nodes n1 and n2
     * in a binary tree.
     * 
     * Approach:
     * - First, find the Lowest Common Ancestor (LCA) of n1 and n2
     * - Then, find the distance from LCA to n1 (d1) and from LCA to n2 (d2)
     * - The answer is the sum: d1 + d2
     */
    static int minDist(Node root, int n1, int n2) {
        Node lca = findLCA(root, n1, n2);     // Step 1: Find LCA
        int d1 = lca_Dist(lca, n1);           // Step 2: Distance from LCA to n1
        int d2 = lca_Dist(lca, n2);           // Step 3: Distance from LCA to n2
        return d1 + d2;                       // Step 4: Return total distance
    }

    // Driver code to test the logic
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

        int n1 = 4, n2 = 6;

        // Output the minimum distance between nodes 4 and 6
        System.out.println("Minimum distance between " + n1 + " and " + n2 + " is: " + minDist(root, n1, n2));
    }
}
