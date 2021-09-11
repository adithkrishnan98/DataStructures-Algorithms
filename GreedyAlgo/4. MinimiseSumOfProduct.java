/*
Question : 
You are given two arrays, A and B, of equal size N. The task is to find the minimum value of A[0] * B[0] + A[1] * B[1] + ... + A[N-1] * B[N-1], where shuffling of 
elements of arrays A and B is allowed. Argument is the array A[] and array B[] and print the minimum sum.

Constraints:
1 <= Size of Arrays <= 10^7
1 <= A[], B[] <= 10^18

Explanation : 
In this problem we need to find the minimum sum of product.So it is a minimization problem and thereby an optimization problem. Such optimization problems can be 
solved using greedy approach. The idea is to multiply minimum element of one array to maximum element of another array. So first we sort both the arrays and then
multiply elements (first from arr1 and last from arr2, second from arr1 and second last from arr2 and so on) from each array and add them to get the minimum sum. 
Since multiplication of elements can lead to overflow conditions for large inputs, we store the result as long datatype.

To sort the arrays, we use a built in Arrays.sort() method which uses a dual pivot quicksort algorithm and takes O(nlogn) time complexity. We can get a better time 
complexity of O(n) by using a linear sorting algorithm like Count sort but that would require O(n) space to store the count and output arrays. But for large input 
sizes count sort becomes inefficient due to large amount of space it utilises.

Below we follow the Arrays.sort() implementation. 

*/

import java.util.Arrays;

public class MinimiseSumOfProducts {
    
    static long minimiseSum(int [] arr1, int [] arr2, int n){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        long result = 0;
        for (int i = 0; i < n; i++)
            result += (arr1[i] * arr2[n - i - 1]);
 
        return result;
    }

    public static void main(String[] args)
    {
        int arr1[] = {3,1,1 };
        int arr2[] = {6,5,4};
        int n1 = arr1.length;
        
        System.out.println(minimiseSum(arr1, arr2, n1));

        int arr3[] = {6,1,9,5,4 };
        int arr4[] = {3,4,8,2,4};
        int n2 = arr3.length;
        
        System.out.println(minimiseSum(arr3, arr4, n2));
    }
}

/*

Output :
23
80

Time Complexity : O(nlogn) since we are using a dual pivot quicksort algorithm
Space Complexity : O(1) as we are not using any extra space. 

Video Link : https://drive.google.com/file/d/1Jr8YnTSWL78as33BV0qmLXFyUt0A5O82/view?usp=sharing

*/
