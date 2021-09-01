/*
Question : 
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is viewed from Left side. Complete the function 
leftView(), which accepts root of the tree as argument.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

Explanation : 
In this problem, we can solve it by recursively traversing though the nodes and keeping track of the level of a node by passing it as a parameter to all the 
recursive calls. We also have to keep track of a max_level and when for a node the level is more than max_level we print that node as it will be the first node 
of that level and then move on to traverse it's left subtree and then the right subtree. 

*/

class Node {
    int key;
    Node left, right;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class LeftViewOfBT {
    Node root;
    int curr_level = 0;
    void printLeftView(Node root, int level){
        if(root == null){
            return;
        }
        if(curr_level < level){
            System.out.println(root.key);
            curr_level = level;
        }
        printLeftView(root.left, level+1);
        printLeftView(root.right, level+1);
        
    }
    public static void main(String[] args) {
        LeftViewOfBT tree = new LeftViewOfBT();
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
        
        tree.printLeftView(tree.root,1);

        LeftViewOfBT tree2 = new LeftViewOfBT();
        tree2.root = new Node(12);
        tree2.root.left = new Node(10);
        tree2.root.right = new Node(30);
        tree2.root.right.left = new Node(25);
        tree2.root.right.right = new Node(40);

        tree2.printLeftView(tree2.root,1);
    }
}

/*
Output :
1
2
4
8

12
10
25

Time Complexity : O(n) as we traverse through n nodes and call the printLeftView() function
Space complexity : O(h) due to stack space during recursive function calls which again depends on height of tree

Video Explanation : https://drive.google.com/file/d/1ihZyIrv6I7Qdz4IHAfNU__peFpjUQeWw/view?usp=sharing

*/


