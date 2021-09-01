package Problems.Trees;

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

// LCA using disjoint sets