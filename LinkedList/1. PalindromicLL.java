/* 
Question :
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.
Create a method isPalindrome(listName) which takes list name as reference and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 50

Explanation : 
One approach for this problem would be to create a stack and then push elements of the linked list into the stack while we traverse it till null. Then we 
again traverse the linked list from head and pop out every element from the stack and we check if the data of head is equal to popped value. If it is we set 
the boolean isPalindrome to true and continue popping and checking other elements, else we set it to false and break the loop. We return the boolean result. 
But this approach takes O(N) time complexity and O(N) space complexity as we are creating a new stack. 

To achieve a better space complexity, we can use another approach of reversing a linked list. In this approach, we first get the middle of the linked list and 
then reverse the second half of the linked list. Nect, we check if first half is equal to the second half by equating every element's value of both halves. 
If it is all equal we set boolean isPalindrome to true. And then finally we can reverse the second half of the linked list back to how it was and construct 
the original linked list again by attaching it back to the first half. This method takes O(N) time complexity but only O(1) space complexity as we are not 
using any extra space. We are simply using pointers to navigate through the linked list. 

*/

// FOUR STEPS TO FIND IF LL IS PALINDROME OR NOT
// 1) Get the middle of the linked list. 
// 2) Reverse the second half of the linked list. 
// 3) Check if the first half and second half are identical. 
// 4) Construct the original linked list by reversing the second half again and attaching it back to the first half

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LLIsPalindrome {
    Node head;
    Node slow_ptr, fast_ptr, second_half;

    public void createNode(int data){
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public boolean isPalindrome(Node head){
        slow_ptr = head;
        fast_ptr = head;
        Node previous_to_slow_ptr = head;
        Node midnode = null;
        boolean result = true;

        // 1. Find the middle node
        if(head!=null && head.next!=null){
            while(fast_ptr!=null && fast_ptr.next!=null){
                fast_ptr = fast_ptr.next.next;
                previous_to_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            // in case of odd elements
            if(fast_ptr!=null){
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;

            }
            // in case of even elements
            second_half = slow_ptr;
            previous_to_slow_ptr.next = null;
          
            // 2. Reverse the second half of linked list
            reverse();
          
            // 3. Compare first and second halves
            result = compareLists(head, second_half);
            
            // Build back the original Linked list if needed
            reverse();
            if(midnode!=null){
                previous_to_slow_ptr.next = midnode;
                midnode.next = second_half;
            }
            else{
                previous_to_slow_ptr.next = second_half;
            }
        }
        return result;
    }

    private void reverse() {
        Node prev = null;
        Node current = second_half;
        Node next;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        second_half = prev;
    }

    private boolean compareLists(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1!=null && temp2!=null){
            if(temp1.data == temp2.data){
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else{
                return false;
            }
        }
        if(temp1==null && temp2==null){
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        LLIsPalindrome llist = new LLIsPalindrome();
            llist.createNode(1);
            llist.createNode(2);
            llist.createNode(1);
            System.out.println(llist.isPalindrome(llist.head) != false ? "Is Palindrome" : "Not Palindrome");
            
            llist.createNode(1);
            llist.createNode(2);
            llist.createNode(3);
            llist.createNode(4);
            System.out.println(llist.isPalindrome(llist.head) != false ? "Is Palindrome" : "Not Palindrome");
    }
}

/* 
Output :
Is Palindrome
Not Palindrome

Time Complexity will be O(N) as we have to traverse through the linked list for N elements while space complexity will be O(1) as we are not using any extra space.

Video Explanation : https://drive.google.com/file/d/1LIR9fir-JG87ClaptQySFnlV5cILb_Y7/view?usp=sharing

*/
