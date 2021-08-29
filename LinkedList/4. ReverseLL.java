/*
Question :
Given a linked list of N nodes. The task is to reverse this list.

The task is to complete the function reverseList(givenList) with givenList reference and returns the list after reversing it.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104

Explanation : 

In the problem, we reverse the linked list by first initialising 3 pointers prev, current and next. prev and next are set to null while current is set to head. 
Then we iterate through the linked list and first store the current.next in the next before chanding it then we change the current.next to prev and then move 
prev and current by one step each. We do this until current becomes null and when it does, then we set the prev to head and return head. 

*/

public class ReverseLinkedList {
    static Node head;

    // create a new node and add at end
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

    Node reverseLL(Node head){
        Node prev = null;
        Node current = head;
        Node next;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    void printList(Node node){
        Node temp = node;
        while(temp!=null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        head = rll.createNode(1, head);
        head = rll.createNode(2, head);
        head = rll.createNode(3, head);
        head = rll.createNode(4, head);
        rll.printList(head);
        head = rll.reverseLL(head);
        System.out.println();
        rll.printList(head);
    }
}

/*
Output :
1 --> 2 --> 3 --> 4 --> NULL
4 --> 3 --> 2 --> 1 --> NULL

Time Complexity : O(n) as we iterate through n nodes of the linked list
Space Complexity : O(1) as we do not utilise any extra space

Video Explanation : https://drive.google.com/file/d/18tx1zovygLnIW0YBLqr8rl9RdpEPl7tZ/view?usp=sharing

*/
