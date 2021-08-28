/* 
Question :
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.Implement a method subArraySum(a[], s)
where A is array of size n and s is the sum.And return the starting and ending positions (0 indexing) of FIRST such occurring subarray from the left if 
sum equals to subarray, else print -1.

Constraints :
1 <= N <= 10^7
1 <= Ai <= 10^10

Explanation :
In the brute force approach, we can use two loops and for every element in the array find the sub array, add elements up and check if they equal to the target sum. 
But this will be taking O(n^2) time complexity as we have to loop through n element and for each of those n elements loop through n-1 elements. Hence, this 
approach is not very efficient. 

Another approach is to use two pointers and loop through the array once. Both left and right pointers start at 0. We keep adding up the elements and incrementing 
right pointer and checking if they are equal or greater than target sum. If they are greater, we decrement the first element's value from the sum and check 
again if sum is equal and we keep doing this while also incrementing the left pointer. When sum becomes equal we print out the left and right pointers with a 
space between them denoting the start and end index. This approach is better than first one as it takes only O(n) time complexity to loop through n elements 
in the array. 

*/
public class SubarrayWithSum {

    private static void FindSubArrayWithSumS(int[] arr, int s) {
        int sum = 0;
        int left, right;
        left = right = 0;
        for(int i = 0; i<arr.length; i++){
            // edge case where sum = 0
            if(s == 0){
                break;
            }

            // keep adding elements to sum
            sum += arr[i];

            // while sum greater than s start subtracting from the beginning and moving the left moving to the right
            while(sum > s){
                sum -= arr[left];
                left++;
            }

            // when sum becomes equal to our target sum, we return the indices
            if(sum == s){
                System.out.println(left + " " + right);
                break;
            }
            right++;
        }
        
        // if no subarray sum equal to target sum was found
        if(right == arr.length || left == arr.length){
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        int [] arr1 = {1,2,3,7,5};
        int s1 = 12;
        FindSubArrayWithSumS(arr1, s1);
        int [] arr2 = {1,2,3,4,5,6,7,8,9,10};
        int s2 = 15;
        FindSubArrayWithSumS(arr2, s2);
    }
}

/* 
Output :
1 3 
0 4

Time Complexity : O(n) as we are looping through n elments of the array 
Space Complexity : O(1) as we are not using any extra space

Video Explanation : https://drive.google.com/file/d/1F12ccUrqjTYGIbhW5jZwjAuSYJXaqZG2/view?usp=sharing

*/
