/* Question :
Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element K. The task is to find the index of the given 
element K in the array A. Complete the function which takes the array A and an integer K denoting the element to be searched in the array and prints the index of 
the element found in the array. If element is not present, then print -1.

Constraints:
1 ≤ N ≤ 10^7
0 ≤ Ai ≤ 10^8
1 ≤ K ≤ 10^8

Explanation :
In this problem, since the array is rotated at some point even though it is sorted, we cannot directly use binary search. We will have to pick up a pivot point 
in the array where we can find the array being rotated at and then divide the array into two sub-arrays and perform the binary search. To do this, the pivot 
element is chosen as the one for which the next element to it is smaller than it. After finding the pivot, we check if the element to be searched for is the 
pivot, else we check both the subarrays and find the element. 

*/

public class SearchInRotatedArray {
    static int pivotedBinarySearch(int arr[], int key)
    {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);
 
        // If pivot is not found, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);
 
        // If pivot is found, then first check if it is the key, else search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }
 

    static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;
 
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }
 
    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low)
            return -1;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }
 
    public static void main(String args[])
    {
        // Let us search 3 in below array
        int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int arr2[] = { 3, 1, 2 };
        int arr3[] = { 3, 5, 1, 2 };
        int key1 = 10;
        int key2 = 1;
        int key3 = 6;
        System.out.println(pivotedBinarySearch(arr1, key1));
        System.out.println(pivotedBinarySearch(arr2, key2));
        System.out.println(pivotedBinarySearch(arr3, key3));
    }
}

/*
Output : 
5
1
-1

Time Complexity : O(logn) since we are performing a binary search. 
Space Complexity : O(1) as we are not utilising any extra space

Video Link : https://drive.google.com/file/d/1XweXIFsOBYDFtIiA4xKJ2IofHtDYBOsk/view?usp=sharing

*/
