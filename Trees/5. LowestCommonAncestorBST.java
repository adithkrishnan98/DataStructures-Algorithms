/*
Question : 
Given a Binary Search Tree (with all unique values) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST. Complete the function LCA() 
which takes the root Node of the BST and two integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the 
given BST.

Expected Time Complexity: O(Height of the BST)
Expected Space Complexity : O(Height of the BST)

Constraints:
1 <= N <= 104">104

Explanation : 
In this problem, we traverse the tree from top to bottom and we see if the node value lies between the numbers n1 and n2. If it does it is the lca of the node. 
We recursviely traverse the BST and check if the node's value is greater than or lesser than our n1 and n2. If it is greater than, then the lca lies on the left 
subtree and we call lca(left_subtree) else if it is smaller than n1 and n2, then the lca lies on the right subtree and we call lca(right_subtree). Otherwise the 
root will be the lca. 

*/

class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class LowestCommonAncestorBST {

    Node root;
      
    Node lca(Node node, int n1, int n2)
    {
        if (node == null)
            return null;
  
        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);
  
        if (node.key < n1 && node.key < n2)
            return lca(node.right, n1, n2);
  
        return node;
    }
  
    public static void main (String[] args) {
        LowestCommonAncestorBST tree = new LowestCommonAncestorBST();
        tree.root = new Node(8);
        tree.root.left = new Node(5);
        tree.root.right = new Node(11);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);
        tree.root.left.left.right = new Node(4);
        tree.root.left.right.left = new Node(6);
        tree.root.right.right = new Node(13);
        tree.root.right.left = new Node(9);
        tree.root.right.right.left = new Node(12);

        int n1 = 4, n2 = 6;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
  
        n1 = 11;
        n2 = 12;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
  
        n1 = 5;
        n2 = 13;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
        
        System.out.println();
        
        LowestCommonAncestorBST tree2 = new LowestCommonAncestorBST();
        tree2.root = new Node(20);
        tree2.root.left = new Node(8);
        tree2.root.right = new Node(22);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(12);
        tree2.root.left.right.left = new Node(10);
        tree2.root.left.right.right = new Node(14);
  
        int n3 = 10, n4 = 14;
        Node t2 = tree2.lca(tree2.root, n3, n4);
        System.out.println("LCA of " + n3 + " and " + n4 + " is " + t2.key);
  
        n3 = 14;
        n4 = 8;
        t2 = tree2.lca(tree2.root, n3, n4);
        System.out.println("LCA of " + n3 + " and " + n4 + " is " + t2.key);
  
        n3 = 10;
        n4 = 22;
        t2 = tree2.lca(tree2.root, n3, n4);
        System.out.println("LCA of " + n3 + " and " + n4 + " is " + t2.key);
    }
}

/*

Output :

LCA of 4 and 6 is 5
LCA of 11 and 12 is 11
LCA of 5 and 13 is 8

LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20

Time complexity : O(h) as we need to traverse through the levels from top to bottom to find the lca
Space complexity : O(h) due to stack space during recursive function calls which again depends on height of tree

Video Explanation : https://drive.google.com/file/d/1PheN1Cpn6oWW6xAgf4JnQ1Fx7bgz1hf4/view?usp=sharing

*/
