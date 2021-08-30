package Problems.LinkedList;

public class PairwiseSwapLL {
    static Node head;

    Node pairwiseSwap(Node head){
        Node temp = head;

        while(temp !=null && temp.next != null){
            swap(temp, temp.next);
            temp = temp.next.next;
        }
        return temp;
    }

    void swap(Node n1, Node n2){
        int temp = n1.data;
        n1.data = n2.data;
        n2.data = temp;
    }

    public Node createNode(int data, Node head){
        Node temp = head;
        Node n = new Node(data);
        if(head==null){
            head = n;
            return head;
        }
        while(head.next!=null){
            head = head.next;
        }
        head.next = n;
        return temp;
    }

    public void printList(Node head){
        while(head!=null){
            System.out.print(head.data + "-->");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        PairwiseSwapLL ps = new PairwiseSwapLL();
        head = ps.createNode(1, head);
        head = ps.createNode(2, head);
        head = ps.createNode(3, head);
        head = ps.createNode(4, head);

        ps.printList(head);
        ps.pairwiseSwap(head);
        System.out.println();
        ps.printList(head);
    }


}
