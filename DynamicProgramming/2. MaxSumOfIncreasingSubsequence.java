/*
Question :
Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array. Complete the function which takes the array and 
prints the required answer.

Constraints:
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106

Explanation :
We can solve this problem similar to Longest Increasing Subsequence problem. We need to use the criteria here as sum instead of length. In the traditional 
recursive approach, let arr[0..n-1] be the input array and L(i) be the length of the LIS ending at index i such that arr[i] is the last element of the LIS. Then 
the recursive equations would be

L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
L(i) = 1, if no such j exists.

To find the LIS for a given array, we need to return max(L(i)) where 0 < i < n.
Formally, the length of the longest increasing subsequence ending at index i, will be 1 greater than the maximum of lengths of all longest increasing subsequences 
ending at indices before i, where arr[j] < arr[i] (j < i). Thus, we see the LIS problem satisfies the optimal substructure property as the main problem can be 
solved using solutions to subproblems. Also when we draw the recursion tree, we can figure out the appearance of overlapping subproblems that get recomputed over 
and over. Thus the time complexity of this approach would be exponential. Hence we can solve this problem using dynamic programming. We use tabulation to avoid 
recomputation of the subproblems. 

*/

public class MaxSumOfIncreasingSubSequence {
    
    static int maxSumIS(int arr[], int n)
    {
        int i, j, max = 0;
        int msum_arr[] = new int[n];
 
        /* Initialize msum_arr values for all indexes */
        for (i = 0; i < n; i++){
            msum_arr[i] = arr[i];
        }
 
        /* Compute maximum sum values in bottom up manner */
        for (i = 1; i < n; i++){
            for (j = 0; j < i; j++){
                if (arr[i] > arr[j] && msum_arr[i] < msum_arr[j] + arr[i]){
                    msum_arr[i] = msum_arr[j] + arr[i];
                }
            }
        }
 
        /* Pick maximum of all msum_arr values */
        for (i = 0; i < n; i++){
            if (max < msum_arr[i]){
                max = msum_arr[i];
            }
        }
 
        return max;
    }
 
    public static void main(String args[]){
        int arr[] = {1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println(maxSumIS(arr, n));

        int arr2[] = {10, 5, 4, 3};
        int n2 = arr2.length;
        System.out.println(maxSumIS(arr2, n2));
    }
}

/*

Output :
106
10

Time Complexity : O(n^2) since we have nested for loops
Space Complexity : O(n) as we create an max sum array of size n

Video Link : https://drive.google.com/file/d/14DNgHDNJltcsWGDYz0flUzj9X_fS2Fv5/view?usp=sharing

*/
