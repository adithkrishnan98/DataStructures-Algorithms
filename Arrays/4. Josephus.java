/* Question :
Given the total number of persons n in a circle and each person kills the person next to it starting at the start point in a fixed direction. The question is 
to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.
Complete the method josephus() that takes the parameter n and returns an integer denoting safe position. 
Check for the constraint in your function- n <= 100 and return -1 for incorrect argument

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Explanation :
This problem can be solved recursively. We first define out base case which is if there is only one person (n = 1) then we return that position as safe spot 
(return 1) else we recursively call josephus for n - 1 persons. But when we do this the position returned by josephus(n-1) will consider position start 
from 1%n + 1. This means that the position returned will be in the form of zero indexing. But we want the answer in terms of one indexing. So what we do is 
we call josephus(n-1) and add 1 as we need to skip 1 person after we kill one and then perform a modulo + 1 operation to get back to the first position after 
we've reached the end of the circle.  So the final equation would be josephus(n - 1) + 1 % n + 1.

Let's take a small example of n = 5. The chosen spot will be 3. Below will be the recursive algorithm applied and the answer derived.

(josephus(5 - 1) + 1 % 5 + 1)
(josephus(4 - 1) + 1 % 4 + 1) = 3 % 5 = 3
(josephus(3 - 1) + 1 % 3 + 1) = 2 % 4 = 2
(josephus(2 - 1) + 1 % 2 + 1) = 1 % 3 = 1
(josephus(1 - 1) + 1 % 1 + 1) = 2 % 2 = 0

*/

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
    
    public static void main(String[] args){
        int n = 5;
        int n1 = 13;
        int n2 = 41;
        int n3 = 101;
        int n4 = -3;
        System.out.println(josephus(n,2));
        System.out.println("The chosen place is " + josephus(n1));
        System.out.println("The chosen place is " + josephus(n2));
        System.out.println("The chosen place is " + josephus(n3));
        System.out.println("The chosen place is " + josephus(n4));
    }
}

/* Output :
3
11
19
-1
-1
 
Time Complexity : O(n) as everytime we kill a person by going around the cirlce there are different states that are being created. From n people, after every kill
it decreases to n-1 people left in the circle. So each time n is being decremeneted by 1 until there is only one person remaining (base case) and n such states will
be created.So time complexity will be O(n)
Space Complexity : O(n) if we consider the functional stack usage for the n recursive calls made

Video Explanation : https://drive.google.com/file/d/1JZlI0Sh23O8DjKcpqvjb7z8qOcNGW5j1/view?usp=sharing
*/


