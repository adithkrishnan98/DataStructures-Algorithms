package Problems.LinkedList;

public class SortLLOf1s2s0s {
    Node head;
    
    public Node addToEnd(Node head, int data){
        Node temp = head;
        Node n = new Node(data);
        if(head==null){
            head = n;
            return n;
        }
        while(head.next!=null){
            head = head.next;
        }
        head.next = n;
        return temp;
    }

    public Node sortList(Node head){
        if(head==null || head.next==null){
            return head;
        }

        // Create three dummy nodes to point to beginning of three linked lists. These dummy nodes are created to avoid many null checks.
        Node head0 = new Node(0);
        Node head1 = new Node(0);
        Node head2 = new Node(0);
 
        // Initialize current pointers for three lists and whole list.
        Node List0 = head0, List1 = head1, List2 = head2;
        
        // Traverse list
        Node temp = head;
        while (temp!=null)
        {
            if (temp.data == 0){
                List0.next = temp;
                List0 = List0.next;
                temp = temp.next;
            }
            else if (temp.data == 1){
                List1.next = temp;
                List1 = List1.next;
                temp = temp.next;
            }
            else{
                List2.next = temp;
                List2 = List2.next;
                temp = temp.next;
            }
        }

        // Attach three lists
        List0.next = (head1.next!=null) ? (head1.next) : (head2.next);
        List1.next = head2.next;
        List2.next = null;
       
        // Updated head
        head = head0.next;
        return head;
    }
    
    public void printList(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortLLOf1s2s0s list = new SortLLOf1s2s0s();
        Node head = null;
        head = list.addToEnd(head, 1);
        head = list.addToEnd(head, 0);
        head = list.addToEnd(head, 2);
        head = list.addToEnd(head, 2);
        head = list.addToEnd(head, 1);
        head = list.addToEnd(head, 2);
        head = list.addToEnd(head, 1);
        head = list.addToEnd(head, 1);
        head = list.addToEnd(head, 0);
        head = list.addToEnd(head, 2);
        list.printList(head);

        head = list.sortList(head);

        list.printList(head);

    }
}
