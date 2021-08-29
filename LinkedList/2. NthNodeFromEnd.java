/* 
Question :
Given a linked list consisting of L nodes and given number N, the task is to find the Nth node from the end of the linked list. The task is to complete the 
function getNthFromLast(listRef, N) which takes two arguments : the list reference and N and you need to return Nth from the end or -1 in case node doesn't exist.

Expected Time Complexity : O(N)
Expected Space Complexity : O(1)

Constraints :
1 <= L <= 10^3
1 <= N <= 10^3

Explanation : 
In this problem, we first need to run through the linked list and get its length. This can be done by initialising a length variable to 0, setting head to 
new node temp and then running through every node we increment this variable until we reach null, thus getting the length of the linked list. Then we reset 
the temp with the original head and then run loop through from 1 to length - position of node from end we want + 1 and we take that temp.data and print it out 
as the Nth node from end. Below is the code implementation.

*/

class NthNode{   // creation of Node with data and next pointer
    int data;
    NthNode next;

    NthNode(int data){  // constructor to initialise a new node with a data
        this.data = data;
        this.next = null;
    }
}
public class NthNodeFromEnd {

    static void NthFromEnd(NthNode head, int target){
        NthNode temp = head;
        int length = 0;
        while(temp!=null){  // running through the LL and incrementing length variable to find length of LL
            temp = temp.next;
            length++;
        }
        if(length < target){  // edge case handled where length is lesser than target node 
            System.out.println("Invalid target");;
        }
        temp = head;
        for (int i = 1; i < length - target + 1; i++){  // looping through the LL to find the target node
            temp = temp.next;
        }
        System.out.println("The " + target + " Node from end is : " + temp.data); 
    }
    public static void main(String[] args) {
        NthNode one = new NthNode(1); // creation of new nodes
        NthNode two = new NthNode(3);
        NthNode three = new NthNode(4);
        NthNode four = new NthNode(6);

        one.next = two;  // setting the next pointers of various nodes
        two.next = three;
        three.next = four;

        NthFromEnd(one, 1);
        NthFromEnd(one, 3);
        NthFromEnd(one, 6);
    }
}

/*
Output :
6
3
Invalid target
 
Time complexity : O(N) for running through the list the first time to find length and O(N) again for looping through the list to find the target node. 
So O(N) + O(N) = O(2N) = O(N). 
Space complexity : O(1) as no extra space is being utilized. 

Video Explanation : https://drive.google.com/file/d/1UkV_hOVQMawF35xUwOxbU115iFcQliwe/view?usp=sharing
*/
