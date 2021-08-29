/*
Question :
Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, if given linked list is 1->2->3->4->5 then the output 
should be 3. If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if given linked list is 
1 ->2->3->4->5->6 then the output should be 4.

The task is to complete the function getMiddle() which takes the list reference and returns data of the middle element of the linked list.

Expected Time Complexity: O(N).
Expected Space Complexity: O(1).

Constraints:
1 <= T <= 500
1 <= N <= 5000

Explanation :
There are different approaches to finding the middle of a linked list. First one is to traverse through the linked list and find the length by incrementing 
it for each node until we reach null. And then we get the middle by diving the length obtained by 2. Next, we traverse the linked list again till we reach the 
middle and then print the middle node. This takes O(n) time complexity. 

Another method is by using two pointers. We keep both pointers at the head first and then we move the fast pointer by 2 while moving the slow pointer by 1 
through the linked list. So the logic is that, when the fast pointer reaches the end of the linked list the slow pointer would've reached the middle. This 
method also has a time complexity of O(n). Below is the code implementation for the second method. 

*/

public class FindMiddleOFLL {
    static Node head;
    int count = 0;

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

    void findMiddle(Node head){
        Node slow_ptr = head;
        Node fast_ptr = head;
        if(head!=null){
            while(fast_ptr!=null && fast_ptr.next!=null){
                slow_ptr = slow_ptr.next;
                fast_ptr = fast_ptr.next.next;
            }
            System.out.println(slow_ptr.data);
        }
    }

    public static void main(String[] args) {
        FindMiddleOFLL ll = new FindMiddleOFLL();
        head = ll.createNode(1, head);
        head = ll.createNode(2, head);
        head = ll.createNode(3, head);
        head = ll.createNode(4, head);
        head = ll.createNode(5, head);
        head = ll.createNode(6, head);

        ll.findMiddle(head);
    }
}

/*
Output :
4

Time Complexity : O(n) as we have to traverse through n nodes of a linked list
Space Complexity : O(1) as no extra space is utilised. 

Video Explanation : https://drive.google.com/file/d/1FEOZtEQfNoTG6z71zqPRBLwyWsBIT4LU/view?usp=sharing

*/
