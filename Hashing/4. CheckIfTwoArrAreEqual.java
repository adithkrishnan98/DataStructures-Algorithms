/*
Question :
Complete the function which takes two arrays A and B of equal size. Find if given arrays are equal or not. Two arrays are said to be equal if both of them contain 
same set of elements, arrangements (or permutation) of elements may be different though. If there are repetitions, then counts of repeated elements must also be 
same for two array to be equal. Print 1 if the arrays are equal else print 0.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 10^7
1 <= A[],B[] <= 10^18

Explanation :
In the brute force approach, we sort both arrays and then linearly compare elements. If we are using Arrays.sort() to sort the elements, the time complexity would 
be O(nLogn) and space complexity would be O(1). Also, another equivalent approach to hashing will be sorting in linear time. We can use count sort to sort both 
the arrays in linear time and then compare elements linearly. This method too takes O(n) time complexity and O(n) space complexity. 

A better approach would be to use hashing where we store all elements of arr1[] and their counts in a hash table. Then we traverse arr2[] and check if the count 
of every element in arr2[] matches with the count in arr1[]. This method takes O(n) time complexity for looping through n elements of the arrays and O(n) space 
complexity for creating hash table. Below is this implementation. 

*/

import java.util.HashMap;

public class CheckIf2ArraysAreEqual {
    static boolean areEqual(int [] arr1, int [] arr2){
        int n = arr1.length;
        int m = arr2.length;
 
        // If lengths of arrays are not equal
        if (n != m){
            return false;
        }
 
        // Store arr1[] elements and their counts in
        // hash map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(arr1[i]) == null){
                map.put(arr1[i], 1);
            }
            else {
                count = map.get(arr1[i]);
                count++;
                map.put(arr1[i], count);
            }
        }
 
        // Traverse arr2[] elements and check if all elements of arr2[] are present same number of times or not.
        for (int i = 0; i < n; i++) {
            // If there is an element in arr2[], but not in arr1[]
            if (!map.containsKey(arr2[i])){
                return false;
            }
            // If an element of arr2[] appears more times than it appears in arr1[]
            if (map.get(arr2[i]) == 0){
                return false;
            }
            count = map.get(arr2[i]);
            --count;
            map.put(arr2[i], count);
        }
 
        return true;
    }

    public static void main(String[] args) {
        int [] arr1 = {1,2,5,4,0};
        int [] arr2 = {2,4,5,0,1};
        if(areEqual(arr1, arr2)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

        int [] arr3 = {1,2,5};
        int [] arr4 = {2,4,15};
        if(areEqual(arr3, arr4)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}

/*

Output :
1
0

Time Complexity : O(n). It takes O(n) time to go through array once and take count of all elements and store in hashmap and then we traverse the array again to 
check if the count of every element in arr2 matches arr1. So total time complexity will be O(n) + O(n) = O(2n) = O(n).
Space Complexity : O(n) as we utilise extra space of n elements to create the hashmap 

Video Link : https://drive.google.com/file/d/1rm39H5BMiDSX_B24vzoOFQZ81nvw4w7U/view?usp=sharing

*/
