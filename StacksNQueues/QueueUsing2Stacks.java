package Problems.StacksNQueues;

import java.util.Stack;

public class QueueUsing2Stacks {
    
    Stack <Integer> stack1 = new Stack <Integer>();
    Stack <Integer> stack2 = new Stack <Integer>();

    public void enQueue(int data){
        stack1.push(data); 
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


        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
