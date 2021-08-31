/*
Question :
Given a binary tree, find if its height is balanced or not. A tree is height balanced if difference between heights of left and right subtrees is not more than 
one for all the nodes of the tree. Complete the function isBalanced() that takes the root node as parameter and returns true, if the tree is balanced or false 
if it isn't.

Constraints :
1 <= Number of nodes <= 10^5
0 <= Data of a node <= 10^6

Expected Time complexity : O(N)
Expected space complexity : O(h) where h = height of tree

Explanation :
This is a pretty simple and straightforward solution. A tree is balanced if the difference between the heights of its left and right subtrees is 1 or less. 
So we first find the left and rightSubTree heights and then we take the absolute difference between them and then compare. We then reciursively check if tree is 
balanced for all the nodes. The height can be found out by adding 1 to the maximum of the heights of left or right subtree. The time complexity for this solution 
would be O(N^2) has we are checking for N nodes in a tree and finding height which itself takes O(N). 
 
Therefore a more optimised solution would be to find if tree is balanced and calculate height in the same function itself without having to call it from a 
different function. We use an atomic boolean to keep track of the balanced state after traversing through every node and checking if tree is balanced or not. 
Atomic boolean is passed by reference as compared to normal boolean which is passed by value. So in recursion, when we use atomic value we can change the value 
easily using the get and set methods as the value is passed by reference whereas when using a normal boolean everytime a new object gets created when setting 
the value of the boolean. 

*/

import java.util.concurrent.atomic.AtomicBoolean;

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

/*
Output :
Binary tree is balanced
Binary tree is not balanced 
 
Time Complexity : O(N) as we need to travel to n nodes and check if tree is balanced
Space complexity : O(h) due to stack space during recursive function calls which again depends on height of tree

Video Explanation : https://drive.google.com/file/d/1kAbXShZ-eYt5o4Y_Ht-mv60PciS7sQtt/view?usp=sharing

*/
