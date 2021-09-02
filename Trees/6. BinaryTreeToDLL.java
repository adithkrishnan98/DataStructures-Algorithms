/*
Question :
Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In -Place. The left and right references in nodes are to be used as previous and next references 
respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. The first node of Inorder traversal 
(leftmost node in BT) must be the head node of the DLL. Complete the function bToDLL() that takes root node of the tree as a parameter and returns the head of DLL.

Expected Time Complexity: O(N).
Expected Space Complexity : O(H). H is the height of the tree and this space is used implicitly for recursion stack.

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000

Explanation : 
We perform in order traversal of the binary tree and while doing so, keep track of the previously visited node in a variable prev. For every visited node, we 
make it next to the prev and previous of this node as prev. 

*/

class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

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

/*

Output :
25==12==30==10==36==15

Time Complexity : O(n) as we are doing a simple in order traversal where n is number of nodes in given binary tree
Space Complexity : O(h) where h is the height of the tree and this space is used implicitly for recursion stack.

Video Explanation : https://drive.google.com/file/d/1thq0oCMSRfBdNVnNjSx8nZYa-HANdlt3/view?usp=sharing

*/
