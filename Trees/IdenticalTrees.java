package Problems.Trees;

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
