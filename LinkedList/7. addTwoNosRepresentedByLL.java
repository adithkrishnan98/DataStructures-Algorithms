/*
Question :
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the 
addition of two input numbers.Complete the function addTwoLists() which takes both the linked lists and returns the new list.

Expected Time Complexity: O(N) + O(M)
Expected Auxiliary Space: O(N) + O(M)

Constraints:
1 <= N, M <= 5000

Explanation :
We solve this problem like how we solved addition of two numbers in elementary school where we hold our fingers in our hands and then count them all together to 
add up both the numbers. If the sum was of a two digit number, we first add the untits place numbers and then if the sum goes more than 9 we have a carry over in 
our mind and we write down just the units sum. And then we add that carry over along with the sum of the numbers in the tens place. The idea to solve this problem 
is the same. We traverse both lists and one by one pick nodes of both lists and add the values. If the sum is more than 9 then make carry as 1 and reduce sum.
If one list has more elements than the other then consider the remaining values of this list as 0. 

Steps :
1. First reverse both the linked lists. Then call the addTwoLists() method on the reversed lista.
2. Traverse the two linked lists from start to end
2. Add the two digits each from respective linked lists.
3. If one of the lists has reached the end then take 0 as its digit.
4. Continue it until both the end of the lists.
5. If the sum of two digits is greater than 9 then set carry as 1 and the current digit as sum % 10
6. Finally we reverse the output list back default order.

*/

public class addTwoNosRepresentedByLL {
    static Node head1, head2, head3, head4;

    // create the lists by adding nodes to the end
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
    
    // reverse the linked list
    static Node reverseLL(Node head){
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

   
    /* Adds contents of two linked lists and return the head node of resultant list */
    Node addTwoLists(Node first, Node second)
    {
        // res is head node of the resultant list
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;
 
        // while both lists exist
        while (first != null || second != null) {
            // Calculate value of next digit in resultant list. The next digit is sum of following things :
            // (i)  Carry
            // (ii) Next digit of first list (if there is a next digit)
            // (ii) Next digit of second list (if there is a next digit)
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
 
            // update carry for next calulation
            carry = (sum >= 10) ? 1 : 0;
 
            // update sum if it is greater than 10
            sum = sum % 10;
 
            // Create a new node with sum as data
            temp = new Node(sum);
 
            // if this is the first node then set it as head of the resultant list
            if (res == null) {
                res = temp;
            }
 
            // If this is not the first node then connect it to the rest.
            else {
                prev.next = temp;
            }
 
            // Set prev for next insertion
            prev = temp;
 
            // Move first and second pointers
            // to next nodes
            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
 
        if (carry > 0) {
            temp.next = new Node(carry);
        }
 
        // return head of the resultant list
        return res;
    }
 
    void printList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }
 
    public static void main(String[] args)
    {
        addTwoNosRepresentedByLL list = new addTwoNosRepresentedByLL();
 
        // creating first list
        head1 = list.createNode(4, head1);
        head1 = list.createNode(5, head1);
        System.out.print("First List is ");
        list.printList(head1);
 
        // creating seconnd list
        head2 = list.createNode(3, head2);
        head2 = list.createNode(4, head2);
        head2 = list.createNode(5, head2);
        System.out.print("Second List is ");
        list.printList(head2);

        Node Rhead1 = reverseLL(head1);
        Node Rhead2 = reverseLL(head2);
 
        // add the two lists and see the result
        Node rs = list.addTwoLists(Rhead1, Rhead2);
        Node result = reverseLL(rs);
        System.out.print("Resultant List is ");
        list.printList(result);

        System.out.println();

        addTwoNosRepresentedByLL list2 = new addTwoNosRepresentedByLL();
 
        // creating first list
        head3 = list2.createNode(6, head3);
        head3 = list2.createNode(3, head3);
        System.out.print("First List is ");
        list.printList(head3);
 
        // creating seconnd list
        head4 = list2.createNode(7, head4);
        System.out.print("Second List is ");
        list.printList(head4);

        Node Rhead3 = reverseLL(head3);
        Node Rhead4 = reverseLL(head4);
 
        // add the two lists and see the result
        Node rs2 = list.addTwoLists(Rhead3, Rhead4);
        Node result2 = reverseLL(rs2);
        System.out.print("Resultant List is ");
        list.printList(result2);
    }
}

/*
Output :
First List is 4 5
Second List is 3 4 5
Resultant List is 3 9 0

First List is 6 3
Second List is 7
Resultant List is 7 0


Time Complexity: O(m + n), where m and n are numbers of nodes in first and second lists respectively. The lists need to be traversed only once.
Space Complexity: O(m + n) as a temporary linked list is needed to store the output number

Video Explanation : https://drive.google.com/file/d/1OUZqS9E5eurV-_fR5XZUpgOHVxHdZF_F/view?usp=sharing
*/
