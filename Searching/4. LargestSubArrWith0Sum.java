/* 
Question :
Given an array with both positive and negative integers, the task is to compute the length of the largest subarray with sum 0. Complete the function maxLength() 
which takes an array A and returns the length of largest subarray with 0 sum. 

Expected time complexity : O(n)
Expected space complexity : O(n)

Constraints :
1 <= N <= 10^4
-1000 <= A[i]  <= 1000

Explanation :
In the brute force approach, we use a nested for loop and calculate each and every sub-array sum and check if sum is zero or not. That takes O(n^2) time 
complexity. A better approach is to use hashmap. We create a new array which stores the sum of all elements upto the last index. We go through the array and keep 
adding every index's value to the sum and check if the sum is already seen before. If it is seen twice then we update value of max_len to a maximum difference of 
the current index and index in hash map and the max_len. Thus we can conclude that there is a zero sum sub-array. 

*/

import java.util.HashMap;

public class LargestSubarrayWith0Sum {
    
    static int maxLen(int arr[])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result
 
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum
            sum += arr[i];
 
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;
 
            if (sum == 0)
                max_len = i + 1;
 
            // Look this sum in hash table
            Integer prev_i = hM.get(sum);
 
            // If this sum is seen before, then update max_len if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                hM.put(sum, i);
        }
 
        return max_len;
    }
 
    public static void main(String arg[])
    {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int arr2[] = {1, 0, 3};
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr));
        System.out.println("Length of the longest 0 sum subarray is " + maxLen(arr2));
    }
}

/*
Output :
Length of the longest 0 sum subarray is 5
Length of the longest 0 sum subarray is 1

Time Complexity : O(n) as we are looping through an array of n elements and using a hash function that has O(1) insertion and retrieval times
Space Complexity : O(n) as we create a hash map to store the previous sums

Video Link : https://drive.google.com/file/d/1kh-Kp2jOE5iwydqzrle7d9osgz4jrNfV/view?usp=sharing

*/
