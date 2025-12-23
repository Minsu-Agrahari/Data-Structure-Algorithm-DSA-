public class Search_Element_BST {
    
    // CUSTOM CLASS (DATA TYPE)
    public static class Node{
        int data;
        Node left;
        Node right;

        Node (int val){
            this.data = val;
        }
    }

    // BUILD TREE
    public static Node treeBuilder(Node root, int val){
        if(root == null){
            root =new Node(val);
            return root;
        }

        if(root.data > val){
            // add the node to the left side of the tree
            root.left = treeBuilder(root.left, val);
        }

        if(root.data < val){
            // add the node in the right side of the tree
            root.right = treeBuilder(root.right, val);
        }
        return root;
    }
    
    public static boolean searchKey(Node root, int key){
        if(root == null) return false;

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return searchKey(root.left, key);
        }

        if(root.data < key){
            return searchKey(root.right, key);
        }

        return false;
    }
    
    // PRINT THE SORTED TREE
    public static void inorder(Node root){
        if (root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = {5, 1, 3, 4, 2, 7};
        int searchKey = 4;
        Node root = null;

        for(int elem : nodes){
            root = treeBuilder(root, elem);
        }
        
        inorder(root);
        System.out.println(searchKey(root, searchKey));
    }
}
