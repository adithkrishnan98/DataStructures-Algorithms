/*
Question :
Implement a Stack using two queues q1 and q2.

You are required to complete the two methods push() which takes an integer 'x' as input denoting the element to be pushed into the stack and pop() which returns the integer popped out from the stack.

Expected Time Complexity: O(1) for push() and O(N) for pop() (or vice-versa).
Expected Space Complexity: O(N)

Constraints:
1 <= Q <= 100
1 <= x <= 100

Explanation :
In the above implementation, we are initialising two queues q1 and q2 as linked list to represent a stack. We cannot directly create queue objects as it is a 
interface. Therefore we will have to use a sub-class implementing this interface like linked list to create objects. For the push() operation, we simply add the 
elements into q1. For the pop() operation, we remove each element within q1 and add to q2 except the last element. We take this last element, remove it from the 
list and store it in a variable called ans. Then until q2 is not empty, we remove elements from q2 and add to q1 and finally return the ans as the popped element. 
Then in order to view the stack we have a printStack() method which prints the stack

*/

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues { 
    Queue  q1 = new LinkedList  ();
    Queue  q2 = new LinkedList  ();
    
    void push(int x){
        q1.add(x);
    }

    int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size()>1){
            int temp=q1.remove();
            q2.add(temp);
        }
        int ans=q1.remove();
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
		return ans;
    }

    void printStack(){
        for(int n : q1){
            System.out.print(n + " "); 
        }
    }

    public static void main(String[] args) {
        StackUsing2Queues s = new StackUsing2Queues();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.printStack();
        System.out.println();
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}

/*
Output :
1 2 3 4 
4
3

The time complexity of push operation is O(1) while for pop it is O(N) as we have to take out N elements from q1 and add to q2. 
The space complexity is O(N) as we are utilizing extra space by creating new queues 1 and 2.  

Video Explanation : https://drive.google.com/file/d/1G2CbmVOkJ4dV7dP-iX89SUVP4H9VA3ap/view?usp=sharing
*/
