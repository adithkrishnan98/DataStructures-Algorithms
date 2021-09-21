/*
Question :
Given an array of n integers, the task is to find the first element that occurs k number of times. If no element occurs k times then print -1. The number k and 
arr[] are arguments. 

Constraints :
a <= Size of A, K <= 10^5
1 <= A <= 10^6

Explanation :
In this problem , the brute force approach is by using two nested for loops. The outer for loop runs from 0 to length - 1 of array and inner loop runs from i+1 
till length -1. We count the number of times a number appears in the array. If the number appears k times then we return it. This method takes O(n^2) time 
complexity as we use nested for loops and O(n) space complexity for storing the count array. 

A better approach is to use a hashmap. First we traverse the array elements from left to right. While traversing we increment their count in the hash table. We 
again traverse the array from left to right and check which element has a count equal to k and we return that element. If no element has a count equal to k then 
we return -1.

*/

import java.util.HashMap;

public class FirstElementToOccurKTimes {

    static int firstElement(int arr[], int k) {
        int n = arr.length;
        HashMap<Integer, Integer> count_map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int counter = 0;
            if(count_map.get(arr[i])!=null){
                counter = count_map.get(arr[i]);
            }
             
            count_map.put(arr[i], counter+1);
        }
 
        for (int i = 0; i < n; i++) 
        {
            if (count_map.get(arr[i]) == k) {
                return arr[i];
            }
        }
 
        // no element occurs k times
        return -1;
    }
 
    public static void main(String[] args) {
        int arr[] = {1, 7, 4, 3, 4, 8, 7};
        int k = 2;
        System.out.println(firstElement(arr, k));
    }
}
/*

Output :
7

Time Complexity : O(n)
Space Complexity : O(n)

Video Explanation : https://drive.google.com/file/d/1d-vq_Ysffof1JC7am2x2Of5Iq8LdTRnm/view?usp=sharing

*/

Video Link :
