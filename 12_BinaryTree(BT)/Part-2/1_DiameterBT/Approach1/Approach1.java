public class Approach1 {
    
    // creating Node Class
    public static class Node{
        int data;
        Node left, right;

        // constructer
        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root){ // --------------------> O(N^2)
        if(root == null) return 0;

        int leftDiameter = diameter(root.left); // O(N)
        int leftHeight = height(root.left); // O(N)

        int rightDiameter = diameter(root.right); // O(N)
        int rightHeight = height(root.right); // O(N)

        int selfHeight = leftHeight + rightHeight + 1; // if longest diameter goes from root ---> that is why "+ 1"

        return Math.max(selfHeight, Math.max(leftDiameter, rightDiameter));
    }
    public static void main(String[] args) {
        /*
        *            1
        *           /  \
        *          2    3
        *         / \  / \
        *        4  5  6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    } 
}
