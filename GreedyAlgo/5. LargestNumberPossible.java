/*
Question : 
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'. Input: integers N and 
S, where N is the number of digits and S is the sum. Print the largest number that is possible. If their is no such number, then print -1

Constraints:
1 <= N <= 50
0 <= S <= 500

Expected Time Complexity: O(n)

Explanation :  
In this problem, we need to get the largest number possible given 2 numbers N and S. So it is a maximization problem and thereby an optimization problem. Such 
optimization problems can be solved using greedy approach. The idea is to fill one by one all digits from leftmost to rightmost (or from most significant digit to 
least significant). 
We compare the remaining sum with 9 if the remaining sum is more than 9, we put 9 at the current position, else we put the remaining sum. Since we fill digits from 
left to right, we put the highest digits on the left side, hence get the largest number.

*/

public class LargestNumberPossible {
    
    static void largestNum(int N, int S){
        // if sum is 0
        if (S == 0)
        {
            System.out.print(N == 1 ? 0 : -1);
            return ;
        }
  
        // Sum greater than the maximum possible sum
        if (S > 9*N)
        {
            System.out.println(-1);
            return ;
        }

        // create result array
        int [] res = new int [N];
        for(int i = 0; i<N; i++){
            if(S >= 9){
                res[i] = 9;
                S -= 9;
            }
            else{
                res[i] = S;
                S = 0;
            }
        }
        for (int i=0; i<N; i++)
            System.out.print(res[i] + "");
            System.out.println();
    }

    public static void main(String[] args) {
        largestNum(2, 9);
        largestNum(3, 20);
    }
}

/*

Output :
90
992

Time Complexity : O(n) as we loop through N digits 
Space Complexity : O(n) as we create a result array of N elements

Video Link : https://drive.google.com/file/d/1T9CiV08d9gJ1D1GLZXeHur9mJ_JMEK_Z/view?usp=sharing

*/
