package Problems.Trees;

import java.util.concurrent.atomic.AtomicBoolean;

// Given a binary tree, find if its height is balanced or not. A tree is height balanced if difference between heights of left 
// and right subtrees is not more than one for all the nodes of the tree. Complete the function isBalanced() that takes the root node as parameter and returns true,
// if the tree is balanced or false if it isn't. 

// Constraints :
// 1 <= Number of nodes <= 10^5
// 0 <= Data of a node <= 10^6

// Expected Time complexity : O(N)
// Expected space complexity : O(h) where h = height of tree

public class CheckForBalancedTree {
    Node root;
    public static int isTreeBalanced(Node root, AtomicBoolean isBalanced){ 
        if (root == null || !isBalanced.get()){
            return 0;
        }
        int leftTree = isTreeBalanced(root.left, isBalanced);
        int rightTree = isTreeBalanced(root.right, isBalanced);


        if(Math.abs(leftTree - rightTree) > 1){
            isBalanced.set(false);
        }
        
        return Math.max(leftTree, rightTree) + 1;
    }

    public static boolean isBalanced(Node root){
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        isTreeBalanced(root, isBalanced);
 
        return isBalanced.get();
    }


    public static void main(String[] args) {
        CheckForBalancedTree tree = new CheckForBalancedTree();
        tree.root = new Node(1);
        tree.root.left = new Node(9);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(7);
        if (isBalanced(tree.root)) {
            System.out.println("Binary tree is balanced");
        }
        else {
            System.out.println("Binary tree is not balanced");
        }

        CheckForBalancedTree tree2 = new CheckForBalancedTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(9);
        tree2.root.left.left = new Node(7);
        if (isBalanced(tree2.root)) {
            System.out.println("Binary tree is balanced");
        }
        else {
            System.out.println("Binary tree is not balanced");
        }

    }
}
