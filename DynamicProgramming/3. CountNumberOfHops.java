/*
Question :
A frog jumps either 1, 2 or 3 steps to go to top. In how many ways can it reach the top. Complete the function which takes input N denoting the total number of 
steps and prints the number of ways to reach the top.

Constraints:
1 ≤ N ≤ 50

Explanation :
Let's say there are n stairs, and a frog is allowed to jump to the next position by skipping one or two or three positions. So there are n positions. The idea is 
that standing at the ith position the frog can move by i+1, i+2, i+3 position. So a recursive function can be formed where at current index i the function is 
recursively called for i+1, i+2 and i+3 positions. There is another way of forming the recursive function. To reach position i, the frog has to jump either from 
i-1, i-2 or i-3 position where i is the starting position. The time complexity of this approach would be O(3^n) as for each state a recursive function is called 
and there are 3 states as discussed above. 

In order to improve this, we can use dynamic programming. As said above, there are n states but the recursive function gets called for 3^n times. This means that 
some states are called repeatedly. So we store the value of states in two ways :

The first way is to keep the recursive structure intact and just store the value in a HashMap and whenever the function is called, return the value store without 
computing (Top-Down Approach). The second way is to take an extra space of size 3 and start computing values of states from 1, 2 .. to n, i.e. compute values of 
i, i+1, i+2 and then use them to calculate the value of i+3 (Bottom-Up Approach). An even more efficient method would be, instead of using array of size n+1 we can 
use array of size 3 because for calculating no of ways for a particular step we need only last 3 steps no of ways. 

Steps :

a) Create an array of size 3 and initialize the values for step 0,1,2 as 1,1,2 (Base cases).
b) Run a loop from 3 to n(dist).
c) For each index compute the value as ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3] and store its value at i%3 index of array ways. If we are computing value for index 3 then the computed value will go at index 0 because for larger indices(4 ,5,6…..) we don’t need the value of index 0.
d) Return the value of ways[n%3].

Below is the code implementation. 

*/

public class CountNumberOfHops {

    static int printCountDP(int steps){
        // Create the array of size 3.
        int [] ways = new int[3];
        int n = steps;
         
         
        // Initialize the bases cases
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
         
        // Run a loop from 3 to n
        // Bottom up approach to fill the array
        for(int i=3 ; i<=n ; i++){
            ways[i%3] = ways[(i-1)%3] + ways[(i-2)%3] + ways[(i-3)%3];
        }
         
        return ways[n%3];
    }
  
    public static void main(String arg[]){
        int steps1 = 1;
        System.out.println(printCountDP(steps1));
        int steps2 = 5;
        System.out.println(printCountDP(steps2));
    }
}

/*

Output :
1
13

Time Complexity : O(n) as there are n steps to traverse through
Space Complexity : O(1) as the space created for 3 ways is constant 

Video Link : https://drive.google.com/file/d/1uyOGDV83eEMzvOUFX4Xm2MBPy4x9lRkl/view?usp=sharing

*/
