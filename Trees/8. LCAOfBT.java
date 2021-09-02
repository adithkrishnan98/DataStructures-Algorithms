/*
Question :
Given a Binary Tree with all unique values and two nodes value n1 and n2. The task is to find the lowest common ancestor of the given two nodes. We may assume 
that either both n1 and n2 are present in the tree or none of them is present. Complete the function lca() that takes nodes, n1, and n2 as parameters and returns 
LCA node as output.

Expected Time Complexity: O(N).
Expected Space Complexity : O(H).
H is the height of the tree.

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000

Explanation : 
The idea is to traverse the tree starting from the root. If any of the given keys (n1 and n2) matches with the root, then the root is LCA (assuming that both keys 
are present). If the root doesn’t match with any of the keys, we recur for the left and right subtree and call LCA again. The node which has one key present in 
its left subtree and the other key present in the right subtree will be the LCA. If both keys lie in the left subtree, then the left subtree has LCA also, 
otherwise, LCA lies in the right subtree. 

*/

public class LCAOfBT {
    Node root;
 
    Node findLCA(int n1, int n2)
    {
        return findLCA(root, n1, n2);
    }
 
    // This function returns pointer to LCA of two given values n1 and n2. This function assumes that n1 and n2 are present in Binary Tree
    Node findLCA(Node node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence by returning root (Note that if a key is ancestor of other, then the ancestor key becomes LCA
        if (node.key == n1 || node.key == n2)
            return node;
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key is present in once subtree and other is present in other, so this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    public static void main(String args[])
    {
        LCAOfBT tree = new LCAOfBT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = " + tree.findLCA(4, 5).key);
        System.out.println("LCA(4, 6) = " + tree.findLCA(4, 6).key);
        System.out.println("LCA(3, 4) = " + tree.findLCA(3, 4).key);
        System.out.println("LCA(2, 4) = " + tree.findLCA(2, 4).key);
    }
}

/*
Output :
LCA(4, 5) = 2
LCA(4, 6) = 1
LCA(3, 4) = 1
LCA(2, 4) = 2

Time Complexity : O(n) as we have to traverse n nodes in a tree
Space Complexity : O(H) if we take into consideration the implicit stack for the various recursion calls to the subtrees of H height.

Video Explanation : https://drive.google.com/file/d/1bxGIjK_aGWV2luXlnRjjcYUDGOOydrjf/view?usp=sharing

*/

