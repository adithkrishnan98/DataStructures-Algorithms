package Problems.Trees;

// class Node {
//     int key;
//     Node left, right;

//     public Node(int key){
//         this.key = key;
//         left = right = null;
//     }
// }

public class BinaryTreeToDLL {
    Node root, head;
      
    // Initialize previously visited node as NULL. Since this is static it is the same value that's is accessible in all recursive calls
    static Node prev = null;
  

    void BinaryTree2DoubleLinkedList(Node root){
        // Base case
        if (root == null)
            return;
  
        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);
  
        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
  
        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }
  
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + "==");
            node = node.right;
        }
    }
  
    // Driver program to test above functions
    public static void main(String[] args)
    {
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
  
        tree.BinaryTree2DoubleLinkedList(tree.root);
          
        tree.printList(tree.head);
  
    }
}