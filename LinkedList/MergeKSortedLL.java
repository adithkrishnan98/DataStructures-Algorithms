package Problems.LinkedList;
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
