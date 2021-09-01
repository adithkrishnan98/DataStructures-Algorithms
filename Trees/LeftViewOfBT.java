package Problems.Trees;

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
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.left = new Node(4);
        // tree.root.left.right = new Node(5);
        // tree.root.right.left = new Node(6);
        // tree.root.right.right = new Node(7);
        // tree.root.left.left.right = new Node(8);
        // tree.root.left.right.left = new Node(9);
        // tree.root.right.right.left = new Node(10);

        // CASE 2
        // tree.root = new Node(1);
        // tree.root.left = new Node(2);
        // tree.root.right = new Node(3);
        // tree.root.left.right = new Node(4);
        // tree.root.left.right.right = new Node(5);
        // tree.root.left.right.right.right = new Node(6);

        // CASE 3
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);


        tree.printLeftView(tree.root,1);
    }
}


