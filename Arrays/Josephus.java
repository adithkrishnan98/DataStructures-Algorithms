package Problems.Arrays;

public class Josephus {
    static int josephus(int n, int k)
    {
        if(n >= 100){
            return -1;
        }
        if(n <= 0){
            return -1;
        }
        if (n == 1)
            return 1;
        else
            return (josephus(n - 1,k) + k - 1) % n + 1; 
    }
    
    // Driver Program to test above function
    public static void main(String[] args){
        int n = 5;
        int n1 = 13;
        int n2 = 41;
        int n3 = 101;
        int n4 = -3;
        System.out.println(josephus(n,2));
        // System.out.println("The chosen place is " + josephus(n1));
        // System.out.println("The chosen place is " + josephus(n2));
        // System.out.println("The chosen place is " + josephus(n3));
        // System.out.println("The chosen place is " + josephus(n4));
    }
}

//  (j(5 - 1, 2) + 2 - 1 % 5 + 1)
//  (j(4 - 1, 2) + 2 - 1 % 4 + 1) = 3
//  (j(3 - 1, 2) + 2 - 1 % 3 + 1) = 2
//  (j(2 - 1, 2) + 2 - 1 % 2 + 1) = 1
//  (j(1 - 1, 2) + 2 - 1 % 1 + 1) = 0 


