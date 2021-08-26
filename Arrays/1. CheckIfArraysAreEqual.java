/* 
Question :
Given two given arrays of equal length, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain the same 
set of elements, arrangements (or permutation) of elements may be different though.

Explanation :
In the brute force approach, we sort both the arrays and go through them linearly to check if elements are equal or not. But this is not so efficient method.
An Efficient Solution to this approach is to use hashing. We store all elements of arr1[] and their counts in a hash map. Then we traverse arr2[] and check 
if the count of every element in arr2[] matches with the count in arr1[].
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
 
        // Store arr1[] elements and their counts in hash map
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
        System.out.println(areEqual(arr1, arr2) ? 1 : 0);

        int [] arr3 = {1,2,5};
        int [] arr4 = {2,4,15};
        System.out.println(areEqual(arr3, arr4) ? 1 : 0);
    }
}

/* Output :
1
0

Time Complexity : O(n) as we have to traverse through n elements in the array
Space Complexity : O(n) since we create a hashmap and store counts of n elements in it


Video Explanation : https://drive.google.com/file/d/1rm39H5BMiDSX_B24vzoOFQZ81nvw4w7U/view?usp=sharing */
