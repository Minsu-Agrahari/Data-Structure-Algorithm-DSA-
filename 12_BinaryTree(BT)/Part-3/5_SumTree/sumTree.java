public class sumTree {
     
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

    public static int sumTree(Node root){
        if(root == null){
            return 0;
        }
        
        int leftChild = sumTree(root.left);
        int rightChild = sumTree(root.right);

        int data = root.data;
        
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = newLeft + leftChild + newRight+ rightChild;
        return data;
    }
    
    public static void preorder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // main function 
    public static void main(String[] args) {
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
 
        sumTree(root);
        preorder(root);
    }
}
 