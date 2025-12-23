public class Approach2 {
    
    // Node class
    public static class Node{

        // data type
        int data;
        Node left, right;

        public Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class Info {
        int diam, ht;

        public Info(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static Info diameter(Node root){ //---------------------------> O(N)
        if(root == null) return new Info(0,0);

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
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

        System.out.println(diameter(root).diam );
    }
}
