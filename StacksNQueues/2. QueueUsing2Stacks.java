/*
Question :
Implement a Queue using 2 stacks s1 and s2. You are required to complete the two methods push or enQueue which take one argument an integer 'x' to be pushed 
into the queue and pop or deQueue which returns a integer popped out from the queue (-1 if the queue is empty).

Expected Time Complexity : O(1) for both push() and O(N) for pop(). (or vice-versa).
Expected Space Complexity : O(N).

Constraints:
1 <= Q <= 100
1 <= x <= 100

Explanation : 
In the above implementation, we are initialising two stacks stack1 and stack2 to represent a queue. For the enQueue() operation, we simply push the elements into 
stack1. For the deQueue() operation, we first check if stack2 is empty, if it is then we keep removing elements from stack 1 and pushing them into stack 2 until 
stack1 is empty. And then we pop out an element from stack2 which fulfills the deQueue() operation. Then in order to view the queue we have a printQueue() method 
which prints the queue. 

*/

import java.util.Stack;

public class QueueUsing2Stacks {
    
    Stack  stack1 = new Stack ();
    Stack  stack2 = new Stack ();

    public void enQueue(int x){
        stack1.push(x); 
    }

    public int deQueue(){
        if(stack1.empty()){
            return -1;
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                int element = stack1.pop();
                stack2.push(element); 
            }      
        }  
        int j = stack2.pop();
        return j;
    }

    public void printQueue(){
        for(int n : stack1){
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        QueueUsing2Stacks q = new QueueUsing2Stacks();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);

        q.printQueue();
        System.out.println();

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}

/*
Output :
1 2 3 4
1
2
3

The time complexity of push or enQueue() operation is O(1) while for pop or deQueue() it is O(N) as we have to take out N elements from stack 1 and add to stack 2. 
The space complexity is O(N) as we are utilizing extra space by creating new stacks 1 and 2. 

*/
