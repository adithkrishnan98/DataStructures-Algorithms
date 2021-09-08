/*
Question : 
Given an array of integers. Find the minimum number of swaps required to sort the array in non-decreasing order. Complete the function minSwaps() which takes the 
array arr[] and prints the minimum number of swaps required to sort the array. If the array is already sorted, return 0.

Constraints:
1 <= size of A <= 105
1 <= A[] <= 106

Expected Time Complexity: O(NlogN).
Expected Space Complexity : O(N).

Explanation : 
This problem can be solved by visualizing it as a graph. We have n nodes and an edge directed from node i to j, if the element at i'th index must be present at 
j'th index in the sorted array. Thus, the graph will contain many non intersecting cycles. Now a cycle with 2 nodes will inly require 1 swap to reach the correct 
ordering and a cycle with 3 nodes will require 2 swaps and so on. So first we store the indexes of the elements given in the array in a hashmap. Next, we sort 
this array. Now we go over every element to check if it has been already visited or if it is present in the right place. If any of these is true, we go on over to 
the next iteration. If both are false, we check for cycle by moving to the next node from one node. If cycle is greater than 0 we say answer = answer + (cycles - 1). 
We check this for all elements and then finally return the answer. 

*/

import java.util.Arrays;
import java.util.HashMap;

public class MinNumberOfSwaps {
    public static int minSwaps(int[] nums)
    {
        int len = nums.length;
        HashMap<Integer, Integer> hM = new HashMap<>();
        for(int i=0;i<len;i++){
            hM.put(nums[i], i);
        }
             
        Arrays.sort(nums);  
         
        // To keep track of visited elements. Initialize all elements as not visited or false.
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);
         
          // Initialize result
        int ans = 0;
        for(int i=0;i<len;i++) {
            // already swapped and corrected or already present at correct pos
            if(visited[i] || hM.get(nums[i]) == i){
                continue;
            }
                    
            int j = i, cycle_size = 0;
            while(!visited[j]) {
                visited[j] = true;
                    
                // move to next node
                j = hM.get(nums[j]);
                cycle_size++;
            }
                
            // Update answer by adding current cycle.
            if(cycle_size > 0) {
                ans += (cycle_size - 1);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int []a = {1, 5, 4, 3, 2};
        System.out.println(minSwaps(a));
        int []b = {8, 9, 16, 15};
        System.out.println(minSwaps(b));
    }
}

/*
Output :
2
1

Time Complexity : O(nlogn) as we are sorting the array using a dual pivot quick sort algorithm
Space Complexity : O(n) as we are creating a hash map of n elements and also a boolean visited array

Video Link : https://drive.google.com/file/d/1bv61pWX182H4uhc6wMzs9pOoSrFPB9-K/view?usp=sharing

*/
