/*
Question :
Given two sorted arrays A and B of size M and N respectively and an element k. The task is to find the element that would be at the k’th position of the final 
sorted array. Complete a function which takes arguments of K, arrays A and B and prints the eleme nt at the Kth position.

Constraints:
1 <= |A|, |B| <= 106">106106
1 <= Ai, Bi <= 106">106106
1 <= K <= |A|+|B| 

Explanation : 
We can solve this problem by multiple approaches. The first one is where we apply merge algorithm of merge sort and merge thr two sub arrays since they are 
already sorted. Then we can easily just return the kth element from the new array. It takes O(n) time complexity and O(n) space complexity as we are using a temp 
array to store the elements while merging. A better approach to save space would be to use three pointers i, j, k. The pointers i and j would be at the start 
indexes of the arrays 1 and 2 and then we check which element is smaller and place the third pointer on that element. We also increment the count variable used 
to count the number of values passed. So if i > j then we set k = i and increment count and i. Then we again compare i and j and find the smallest and assign k 
to that index and increment count. We keep doing this while i and j are less than arr1.length anf arr2.length and also until we reach our kth element. When 
count == k, we stop and return the arr[k]. This method has O(n + m) time compexity where n and m are lengths of the arrays and O(1) space since we aren't using 
any additional space. If n == m then time complexity would be O(n)

An even better appoach would be to apply divide and conquer algorithm. Here, we divide k by 2 and then recurse for finding the kth element of the subarrays. We 
define a new sub problem with half the size of one of the arrays. This would have a time complexity of O(logn) as we keep breaking k down until k becomes equal 
to 1. The space complexity will be O(n) as we are using a temp array to copy elements from original array. Below is the code for this approach.

*/

import java.util.Arrays;

public class KthElementOfSortedArrays {
    
    static int findKthElement(int arr1[], int m, int arr2[], int n, int k){
        if (k > (m + n) || k < 1){
            return -1;
        }
 
        // m > n
        if (m > n){
            return findKthElement(arr2, n, arr1, m, k);
        }
 
        // Check if arr1 is empty returning k-th element of arr2
        if (m == 0){
            return arr2[k - 1];
        }
 
        // Check if k = 1 return minimum of first two elements of both arrays
        if (k == 1){
            return Math.min(arr1[0], arr2[0]);
        }
 
        // Apply divide and conquer 
        int i = Math.min(m, k / 2); // 3
        int j = Math.min(n, k / 2); // 3
 
        if (arr1[i - 1] > arr2[j - 1]) {
           
            // Now we need to find only k-j th element since we have found out the lowest j
            int temp[] = Arrays.copyOfRange(arr2, j, n);
            return findKthElement(arr1, m, temp, n - j, k - j);
        }
 
        // Now we need to find only k-i th element since we have found out the lowest i
        int temp[] = Arrays.copyOfRange(arr1, i, m);
        return findKthElement(temp, m - i, arr2, n, k - i);
    }
 

    public static void main(String[] args) {
        int [] arr1 = {1, 4};
        int [] arr2 = {2, 3, 6};
        int m = arr1.length;
        int n = arr2.length;
        int k = 3;

        int ans = findKthElement(arr1, m, arr2, n, k);
        if (ans == -1){
            System.out.println("Invalid query");
        }
        else{
            System.out.println(ans);
        }

        int [] arr3 = {2, 3, 6, 7, 9};
        int [] arr4 = {1, 4, 8, 10};
        int m1 = arr3.length;
        int n1 = arr4.length;
        int k1 = 5;

        int ans1 = findKthElement(arr3, m1, arr4, n1, k1);
        if (ans1 == -1){
            System.out.println("Invalid query");
        }
        else{
            System.out.println(ans1);
        }
    }
}

/*

Output :
3
6

Time Complexity : O(logk) since we are diving both arrays by k/2 and then recusing for both the sub arrays. We do this until k = 1.
Space Complexity : O(n) as we are using a temp array to copy elements from original array

 Video Link : https://drive.google.com/file/d/1jau-KZO0RP9OmgN2T6J5BXCvSY9T4YTE/view?usp=sharing
 
 */
