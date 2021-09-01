package Problems.Trees;

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
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(2);
        // tree.root.left.left = new Node(3);
        // tree.root.left.right = new Node(4);
        // tree.root.right.left = new Node(4);
        // tree.root.right.right = new Node(3);
        boolean result = tree.isSymmetric(tree.root.left, tree.root.right);
        System.out.println(result);
    }
}
