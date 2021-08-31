/*
Question :
Given a Binary Tree, find diameter of it. The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
You need to complete the function diameter() that takes root node as parameter and returns the diameter.

Expected Time Complexity: O(N).
Expected Space Complexity : O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 10000
1 <= Data of a node <= 1000

Explanation :
The diameter of a tree can be calculated as the maximum of the diameters of left subtree, the diameter of right subtree and the maximum of the heights of the 
left subtree +right subtree + 1. In the brute force approach, we travel to every node and recursively call the diameter function for its left and right children 
which inturn calls the height function respectively. This thus takes exponential time complexity O(n^2) as we are making recursive calls within recursive calls 
each individually of O(n) time complexity.

So a better approach to optimise time complexity is to find the diameter while calculating the height or maxDepth. The diameter or the longest path that passes a 
given node as root node will be the maximum value of (leftSubtreeHeight + rightSubTreeHeight + 1) for each node. So we calulate this value and keep updating it 
for every node if this node has a greater value than previous node. Finally we return the max value. This approach takes O(n) time complexity. 

*/

class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class DiameterOfBT{
    int max = Integer.MIN_VALUE;
    Node root;
    public int diameterOfBinaryTree(Node root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        int leftTreeDepth = maxDepth(root.left);
        int rightTreeDepth = maxDepth(root.right);
        
        max = Math.max(max, leftTreeDepth + rightTreeDepth + 1);
        
        return Math.max(leftTreeDepth, rightTreeDepth) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBT tree = new DiameterOfBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.right.right.left = new Node(10);

        System.out.println(tree.diameterOfBinaryTree(tree.root));  
    }
}

/*
Output :
7

Time Complexity : O(n) as we have to traverse through n nodes of a binary tree
Space Complexity : O(1) as we do not utilise any extra space 

Video Explanation : https://drive.google.com/file/d/1mF3nYGClXOJq2MP7OygzYLcyIu01oXcB/view?usp=sharing

*/
