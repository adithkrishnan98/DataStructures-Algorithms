/* 
Question :
Given a singly linked list of size N. The task is to swap elements in the linked list pairwise. For example, if the input list is 1 2 3 4, the resulting list 
after swaps will be 2 1 4 3. Complete the function pairWiseSwap() which takes the the linked list and retu rns the modified linked list after swapping pairwise 
nodes.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103

Explanation : 
We start from the head node and traverse the list. While traversing we swap data of each node with its next node’s data. 
*/


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

/*
Output :
1-->2-->3-->4-->NULL
2-->1-->4-->3-->NULL

Time Complexity : O(n) as we traverse through n nodes of a linked list 
Space Complexity : O(1) as we do not use any extra space

Video Explanation : https://drive.google.com/file/d/1efcM5ICkwmQLzFpC8siA7aRKKY_-m_vy/view?usp=sharing

*/
