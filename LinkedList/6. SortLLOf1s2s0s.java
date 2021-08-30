/*
Question :
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros 
segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s. Complete the function segregate() which segregates the nodes in the 
linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 10^3

Explanation :
We can solve this problem by two approaches. In the first approach, we traverse the list and count the number of 0s, 1s and 2s. Let's assume the counts to be 
n1, n2 and n3 respectively. Next, we traverse the list once more and fill the first n1 nodes with 0, then n2 nodes with 1 and n3 nodes with 2. The time complexity 
for this approach would be O(n) and space complexity would be O(1) but this method would not work if the values are associated with some data. For eg : let's 
say the 3 values represent 3 different colours and different types of objects are assiciated with the colours and we need to sort the objects based on that. 

So a better approach would be to sort the list by changing the links between the different nodes. In this method, we iterate through the linked list while 
maintaining 3 pointers named List0, List1 and List2 to point to current ending nodes of linked lists containing 0, 1, and 2 respectively. For every traversed 
node, we attach it to the end of its corresponding list. Finally, we link all three lists. To avoid many null checks, we use three dummy pointers head0, head1
and head2 that work as dummy headers of three lists.

*/

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

/*
Output : 
1 0 2 2 1 2 1 1 0 2  
0 0 1 1 1 1 2 2 2 2

Time Complexity : O(n) since we need to traverse n nodes in the list
Space Complexity : O(1) as we do not utilise any extra space

Video Explanation : https://drive.google.com/file/d/11e86N8bv_O6-tr6DbnLTAlHtRBh6Maee/view?usp=sharing

*/
