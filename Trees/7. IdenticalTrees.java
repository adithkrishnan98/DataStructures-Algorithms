/*
Question : 
Given two binary trees, the task is to find if both of them are identical or not. Complete the function isIdentical() that takes two roots as parameters and 
returns true or false.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 1000
1 <=Data of a node <= 1000

Explanation : 
Two trees are identical when they have same data and arrangement of data is also same. To identify if two trees are identical, we need to traverse both trees 
simultaneously, and while traversing we need to compare data and children of the trees. 

*/

public class IdenticalTrees {
    Node root1, root2;
    static boolean isIdentical(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null){
            return ( root1.key == root2.key && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right) );
        }
        return false;
    }

    public static void main(String[] args) {
        IdenticalTrees tree = new IdenticalTrees();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(9);
        tree.root1.right = new Node(8);
        tree.root1.left.left = new Node(7);
        
        tree.root2 = new Node(1);
        tree.root2.left = new Node(9);
        tree.root2.right = new Node(8);
        tree.root2.left.left = new Node(7);


        boolean result = isIdentical(tree.root1, tree.root2);
        String msg = result ? "Trees are identical" : "Trees are not identical";
        System.out.println(msg);

    }
}

/*
Output :
Trees are identical

Time Complexity : O(m). Complexity will be according to the tree with lesser number of nodes. Let number of nodes in two trees be n and m then complexity of 
isIdentical() will be O(n) where n < m.
Space Complexity : O(H) if we take into consideration the implicit stack for the various recursion calls to the subtrees of H height.

Video Explanation : https://drive.google.com/file/d/151RXythXwLSHYcP9030QbX_9tnM4w4jr/view?usp=sharing

*/
