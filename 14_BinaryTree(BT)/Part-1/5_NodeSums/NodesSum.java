
public class NodesSum {
    
    static class Node {
        int data;
        Node left, right;
        
        // constructer
        public Node (int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int sumNode(Node root){
        if(root == null){
            return 0;
        }

        int leftSum  = sumNode(root.left);
        int rightSum =  sumNode(root.right);

        return leftSum + rightSum + root.data;
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
        root.right = new Node(2);
        
        root.left.left = new Node(0);
        root.left.right = new Node(3);

        root.right.left = new Node(0);
        root.right.right = new Node(3);

        System.out.println("The sum of all the nodes in a Tree = " +sumNode(root.left));
        System.out.println("The sum of all the nodes in a Tree = " +sumNode(root.right));
    }
}
