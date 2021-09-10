/*
Question : 
Given an array consisting cost of toys and an integer K depicting the amount with you, Maximise the number of toys you can have with K amount. Complete the 
function with arguments - integer K depicting the value of K and array of the cost of toys. Print the maximum toys.

Constraints:
1 ≤ Size of A[] ≤ 1000
1 ≤ K ≤ 10000
1 ≤ A[i] ≤ 10000

Explanation : 
In this problem, we first sort the array and then start from the beginning till the end summing the elements. After every sum we check if it is lesser than or 
equal to the available cash we have, if it is then we increment the count variable and continue to the next element. If it goes beyond our cash then we return 
the count. 

*/

import java.util.Arrays;

public class MaximiseToys {


    static int maximiseToys(int [] arr, int total){
        Arrays.sort(arr); // O(nlogn)
        int count = 0;
        int sum = 0;
        for(int i = 0; i<arr.length;i++){ // O(n)
            sum += arr[i];
            if(sum<=total){
                count++;
                continue;
            }
            else{
               return count;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {1, 12, 5, 111, 200, 1000, 10}; 
        int total = 50;
        int result = maximiseToys(arr, total);
        System.out.println(result);
    }
}

/*

Output :
4

Time Complexity : O(nlogn). The sorting takes O(nlogn) time and we loop through the n elements to find the sums which takes O(n). So total time complexity is 
O(nlogn + n) = O(nlogn) since it is the bigger term. 
Space Complexity : O(1) as we are not using any extra space.

Video Link : https://drive.google.com/file/d/1hMEcMxpi1dVeV2QHwE4ITbm1k9YbCW71/view?usp=sharing

*/
