/*
Question :
Given a Binary Tree. Check whether it is Symmetric or not - the binary tree is a Mirror image of itself or not. 

Explanation :
In this problem, the function isSymmetric(Node node1, Node node2) takes two trees as arguments and checks if they are mirror images of each other. 
For two trees to be mirrror images thier roots will have to have same values, the left subtree of the left tree and the right subtree of the right tree must be 
mirror images and similarly the right subtree of the left tree and left subtree of the right tree will have to be mirror images. So in that order, we first we 
check if both the nodes are null if it is then we return true. Next we check if both nodes are not null and then their keys are equal, we recursively call 
isSymmetric() method for the left tree's left subtree and right tree's left subtree and for right subtree of left tree and left subtree of right tree. Else we 
return false finally. 

*/

class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class CheckIfTreeIsSymmetric {
    Node root;
    boolean isSymmetric(Node node1, Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1!=null && node2!=null && node1.key == node2.key ){
            return(isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left));
        }
        return false; 
    }
    public static void main(String[] args) {
        CheckIfTreeIsSymmetric tree = new CheckIfTreeIsSymmetric();
        tree.root = new Node(5);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(0);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(4);
        tree.root.left.left.left = new Node(0);
        tree.root.left.left.right = new Node(8);
        tree.root.right.left.left = new Node(0);
        tree.root.right.left.right = new Node(6);
        tree.root.right.right.left = new Node(0);
        tree.root.right.right.right = new Node(0);
        boolean result = tree.isSymmetric(tree.root.left, tree.root.right);
        System.out.println(result);


        CheckIfTreeIsSymmetric tree2 = new CheckIfTreeIsSymmetric();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(2);
        tree2.root.left.left = new Node(3);
        tree2.root.left.right = new Node(4);
        tree2.root.right.left = new Node(4);
        tree2.root.right.right = new Node(3);
        boolean result2 = tree2.isSymmetric(tree2.root.left, tree2.root.right);
        System.out.println(result2);
    }
}

/*
Output :
false
true

Time complexity : O(N) as we have to traverse through N nodes of the tree
Auxillary Space complexity : O(h) where h is maximum height of tree

Video Explanation : https://drive.google.com/file/d/1dCeakFsQTouYnwEHiDS3Ey0zGDzzapLq/view?usp=sharing

*/
