/*
Question : 
Given an array of positive and negative integers, segregate them in linear time and constant space. Output should print all negative numbers followed by all 
positive numbers.
For eg. Input: [9,-3,5,-2,-8,-6,1,3]

a) Using partitioning logic of quicksort.
Output: [-3,-2, -8,-6, 5,9,1,3]

Explanation : 
One way to segregate postitive and negative numbers is by using the partioning logic of quicksort. We take 0 as the pivot element and loop through the array 
element, while doing so check for negative elements and place them before the pivot and then incrementing the pivot element after every such swap. 

*/

import java.util.Arrays;
public class SegregatePosNegNums {
    
    public static void partition(int [] arr, int start, int end){
        int pivot = start;
        for(int i = start; i<end; i++){
            if(arr[i] < 0){
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                pivot++;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {9, -3, 5, -2, -8, -6, 1, 3 };
        partition(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

/*
Output :
[-3, -2, -8, -6, 5, 9, 1, 3]

Time Complexity : O(n) as we loop through n elements in the array
Space Complexity : O(1) as we do not utilise any extra space

Video Link : https://drive.google.com/file/d/1gEThbaVLcS_2tXKzAniiSWi1Bb9Hflnm/view?usp=sharing

*/

/*
b) Using merge sort logic to maintain the same relative ordering.
Output: [-3,-2,-8,-6, 9,5,1,3]

Explanation : 
The problem with the previous approach is that even though we can segregate positive and negative numbers but not without distrupting their relative ordering. 
So using the merge sort logic maintains the same relative ordering of those elements. 

*/

import java.util.Arrays;

public class SegregatePosNegNums {
    
    public static void merge(int[] arr, int[] aux, int low, int mid, int high)
    {
        int k = low;
 
        // copy negative elements from the left subarray
        for (int i = low; i <= mid; i++)
        {
            if (arr[i] < 0) {
                aux[k++] = arr[i];
            }
        }
 
        // copy negative elements from the right subarray
        for (int j = mid + 1; j <= high; j++)
        {
            if (arr[j] < 0) {
                aux[k++] = arr[j];
            }
        }
 
        // copy positive elements from the left subarray
        for (int i = low; i <= mid; i++)
        {
            if (arr[i] >= 0) {
                aux[k++] = arr[i];
            }
        }
 
        // copy positive elements from the right subarray
        for (int j = mid + 1; j <= high; j++)
        {
            if (arr[j] >= 0) {
                aux[k++] = arr[j];
            }
        }
 
        // copy back to the original array to reflect sorted order
        for (int i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }
 
    // Segregate positive and negative integers using a mergesort-like routine
    public static void partition(int[] arr, int[] aux, int low, int high)
    {
        // Base case
        if (high == low) {
            return;
        }
 
        // find midpoint
        int mid = (high + low) / 2;
 
        partition(arr, aux, low, mid);          // split/merge left half
        partition(arr, aux, mid + 1, high);     // split/merge right half
 
        merge(arr, aux, low, mid, high);        // join the two half runs
    }

    public static void main(String[] args)
    {
        int[] arr = { 9, -3, 5, -2, -8, -6, 1, 3 };
        int[] aux = Arrays.copyOf(arr, arr.length);
 
        partition(arr, aux, 0, arr.length - 1);
 
        System.out.println(Arrays.toString(arr));
    }
}

/*

Output :
[-3, -2, -8, -6, 9, 5, 1, 3]


Time Complexity : O(nlogn) as merge sort always divides the array into two halves and takes linear time to merge two halves.
Space Complexity : O(n) as we create a temp array to store sorted elements

Video Link : https://drive.google.com/file/d/1hc3Y6-BENAjfLXD2zcRH8SX18PssXS8L/view?usp=sharing

*/
