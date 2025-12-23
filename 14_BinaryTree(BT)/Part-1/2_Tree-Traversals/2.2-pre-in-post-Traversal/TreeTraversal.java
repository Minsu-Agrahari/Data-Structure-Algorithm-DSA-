p,ublic class TreeTraversal {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        public static Node buildTree(int[] nodes){
            idx ++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrderTraversal(Node root){
            if(root == null){
                System.out.print("-1, ");
                return;
            }
            System.out.print(root.data + ", ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public static void inOrderTraversal(Node root){
            if(root == null){
                System.out.print("-1, ");
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + ", ");
            inOrderTraversal(root.right);
        }

        public static void postOrderTraversal(Node root){
            if(root == null){
                System.out.print("-1, ");
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + ", ");
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);

        System.out.println("---- B-Tree => **Pre-Order Traversal ----");
        tree.preOrderTraversal(root);

        System.out.println("\n\n---- B-Tree => **In-Order Traversal----");
        tree.inOrderTraversal(root);
        
        System.out.println("\n\n---- B-Tree => **Post-Order Traversal----");
        tree.postOrderTraversal(root);
    }
}
