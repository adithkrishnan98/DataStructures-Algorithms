/*
Question :
Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.
Complete the function mergeKList() which merges the K given lists into a sorted one.

Expected Time Complexity: O(n.k.logk)
Expected Space Complexity : O(k)

n is the maximum size of all the k linked lists

Constraints
1 <= K <= 10^3

Explanation :
To solve this problem, we use a priority queue implemented as min heap with help of compare function which orders elements in the ascending order. We add the 
first nodes of all three lists and then we check until queue is not empty and pop out the first element and remove it from the queue. We check if that element 
has another element next to it, if it does we add that to the queue as well. And then we check if head is null, if it is we set the popped element as head 
as last. Then the next time when head isn't null, we set the last.next to the next incoming element. Thus we get a sorted merged list of 3 individual lists. 

Steps :
a) Create a min-heap and insert the first element of all the ‘k’ linked lists.
b) As long as the min-heap is not empty, perform the following steps:
           b.1) Remove the top element of the min-heap (which is the current minimum among all the elements in the min-heap) and add it to the result list.
           b.2) If there exists an element (in the same linked list) next to the element popped out in previous step, insert it into the min-heap.
c) Return the head node address of the merged list.

*/

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;



public class MergeKSortedLL {
    
 
    // function to merge k sorted linked lists
    public static Node mergeKSortedLists(Node arr[], int k){
        Node head = null, last = null;
 
        // priority_queue 'pq' implemeted as min heap with the help of 'compare' function
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b)
            {
                return a.data - b.data;
            }
        });

        // push the head nodes of all the k lists in 'pq'
        for (int i = 0; i < k; i++){
            if (arr[i] != null){
                pq.add(arr[i]);
                Iterator <Node> g_iterator = pq.iterator();
  
                System.out.print("Iterator values : ");
                while(g_iterator.hasNext())
                {
                    Node it = g_iterator.next();
                    System.out.print(it.data + " ");
                }
                System.out.println("");
            }
        }

        // loop till 'pq' is not empty
        while (!pq.isEmpty()) {
            // get the top element of 'pq'
            Node top = pq.peek();
            System.out.println("Top : " + top.data);
            pq.remove();
            Iterator <Node> g_iterator = pq.iterator();
  
                System.out.print("Iterator values : ");
                while(g_iterator.hasNext())
                {
                    Node it = g_iterator.next();
                    System.out.print(it.data + " ");
                }
                System.out.println("");
                System.out.println();
            // check if there is a node next to the 'top' node in the list of which 'top' node is a member
            if (top.next != null){
                // push the next node in 'pq'
                pq.add(top.next);
                Iterator <Node> h_iterator = pq.iterator();
  
                System.out.print("Iterator values : ");
                while(h_iterator.hasNext())
                {
                    Node it = h_iterator.next();
                    System.out.print(it.data + " ");
                }
                System.out.println("");
            }
 
            // if final merged list is empty
            if (head == null) {
                head = top;
                // points to the last node so far of the final merged list
                last = top;
            }
            else {
                // insert 'top' at the end of the merged list so far
                last.next = top;
 
                // update the 'last' pointer
                last = top;
            }
        }
        // head node of the required merged list
        return head;
    }
    
    // function to print the singly linked list
    public static void printList(Node head){
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
 
    public static void main(String args[]){
        int k = 3; // Number of linked lists
    
        // an array of pointers storing the head nodes of the linked lists
        Node arr[] = new Node[k];
 
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
 
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
 
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
 
        // Merge all lists
        Node head = mergeKSortedLists(arr, k);
        printList(head);
    }
}

/*
Output :
0 1 2 3 4 5 6 7 8 9 10 11

Time Complexity : O(nklogk) where n is size of each linked list, k is the total number of lists and insertion and deletion of min heap requires logk time. 
Space Complexity : O(k) as the priority queue created will have a maximum of k number of elements

Video Explanation : https://drive.google.com/file/d/1pgLEx5KsMEKskEwzColJuVEiRI6797Jm/view?usp=sharing
*/
