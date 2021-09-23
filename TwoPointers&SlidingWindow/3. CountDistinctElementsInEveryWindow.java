/*
Question :
Given an array of integers and a number k, find the count of distinct elements of every window of size k in the array. Complete the function countDistinct() which takes array A[] and window size k as inputs and returns an array containing count of distinct elements in every contiguous window of size k in the array. 

Expected Time Complexity : O(N)
Expected Space Complexity : O(N)

Constraints :
1 <= N <= K <= 10^5
1 <= Ai <= 10^5 for every valid i

Explanation :
In the brute force approach, we can solve this problem by going through every window in the array and keeping the count of distinct elements in them. We have i 
from 0 to k and another for loop within it, j starting at 0 and being less than i and we check of the elements are equal. If they are, we break the inner for 
loop and check if the indexes are equal. If they are then we increment dist_count. We keep doing this until we get distinct elements count for that particular 
window and then printing them before moving on to the next window. This method takes O(nk^2) time complexity and O(1) space complexity. 

A better solution would to use hashing. The trick is to use the count of the previous window while sliding the window. To do this we use hash map that stores
elements of the current window.

Steps :

Create an empty hash map. Let the hash map be hM.

a) Initialize the count of distinct element as dist_count to 0.
b) Traverse through the first window and insert elements of the first window to hM. The elements are used as key and their counts as the value in hM. Also, keep 
updating dist_count
c) Print distinct count for the first window.
d) raverse through the remaining array (or other windows). 
e) Remove the first element of the previous window. 
f) If the removed element appeared only once, remove it from hM and decrease the distinct count, i.e. do “dist_count–“ else (appeared multiple times in hM), then 
decrement its count in hM
g) Add the current element (last element of the new window) 
h) If the added element is not present in hM, add it to hM and increase the distinct count, i.e. do “dist_count++” else (the added element appeared multiple times), increment its count in hM
 
*/

import java.util.HashMap;

public class CountDistinctElements {
    
    static void countDistinct(int arr[], int k)
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
        // Traverse the first window and store count of every element in hash map
        for (int i = 0; i < k; i++)
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
 
        // Print count of first window
        System.out.print(hM.size() + " ");
 
        // Traverse through the remaining array
        for (int i = k; i < arr.length; i++) {
 
            // Remove first element of previous window if there was only one occurrence
            if (hM.get(arr[i - k]) == 1) {
                hM.remove(arr[i - k]);
            }
 
            else // reduce count of the removed element
                hM.put(arr[i - k],  hM.get(arr[i - k]) - 1);           
 
            // Add new element of current window. If this element appears first time, set its count as 1,
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
 
            // Print count of current window
            System.out.print(hM.size() + " ");
        }
    }
 
    public static void main(String arg[])
    {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        countDistinct(arr, k);
    }
}

/*

Output :
3 4 4 3

Time Complexity : O(n) as we traverse the array only once
Space Complexity : O(n) since hash map requires extra space 

Video Link : https://drive.google.com/file/d/13V-SWiNF6VniQ4gqPuuh5VHAGLohwbJW/view?usp=sharing

*/
