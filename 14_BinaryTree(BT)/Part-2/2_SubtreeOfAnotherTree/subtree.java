/*
 * Subtree of another Tree
 * 
 * Given the root of two binary tree and subRoot, return true if there is a subtree of root with the same strucuture and node values of subRoot and false otherwise.
 * 
 */

public class subtree {
    static class Node{
        int data;
        Node left, right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdetical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }

        if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdetical(node.left, subRoot.left)){
            return false;
        }

        if(!isIdetical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){
        if(root == null) return false;

        if(root.data == subRoot.data){
            if(isIdetical(root, subRoot)){
                return true;
            }
        }

        return isIdetical(root.left, subRoot) || isIdetical(root.right, subRoot);
    }
    
    
    public static void main(String[] args) {
        /*
         *          1
         *         /  \
         *        2    3 
         *       / \  / \
         *      4   5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

         /*
          *         2
          *        / \
          *       4   5
          */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // subRoot.right = new Node(52);

        System.out.println(isSubtree(root, subRoot));
    }
}
