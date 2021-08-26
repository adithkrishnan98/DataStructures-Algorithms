/* 
Question :
Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it. Complete the function whose argument is the array A and which prints the position at which the elements are at equilibrium if no equilibrium point exists print -1.

Constraints:
1 <= N <= 106
1 <= Ai <= 108

Explanation : 
In the brute force approach, we can use nested loops. Outer loops picks out each element and an inner loop checks if the picked index is equilibrium index 
or not by calculating left sum and right sum and equating them to find if they are equal. This takes O(n^2) time complexity and is thus not very efficient. 

An efficient method would be to first calculate the entire sum of the array. Then initialise the left sum as 0. Now we caluclate right sum by subtrating 
each element from the sum and equating it to the left sum. If it is equal we return that index, else we add that index's value to the left sum and move on 
to the next index and follow the similar steps. This method takes O(n) time as we are using two individual for loops. Below is its code implementation :
*/

public class EquilibriumPoint {

    int findEquilibrium(int [] A, int n){
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
 
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i){
            sum += A[i];
        }
 
        for (int i = 0; i < n; ++i) {
            sum -= A[i]; // sum is now right sum for index i
            if (leftsum == sum){
                return i;
            }
            leftsum += A[i];
        }
 
        /* If no equilibrium index found, then return 0 */
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumPoint ep = new EquilibriumPoint();
        int [] ar = {1};
        int n = ar.length;
        int [] ar2 = {1,3,5,2,2};
        int n2 = ar2.length;
        int result1 = ep.findEquilibrium(ar, n);
        int result2 = ep.findEquilibrium(ar2, n2);
        System.out.println(result1);
        System.out.println(result2);
    }
}

/* Output :
0
2

Time Complexity : O(n) as we first find find the sum of whole array (for n elements) which takes O(n) time and then we loop through n elements again 
and find left sum which takes O(n) again. So total time complexity is O(n) + O(n) = O(2n) = O(n)
Space Complexity : O(1) as we do not utilize any extra space

Video Explanation : https://drive.google.com/file/d/1h_sU8QWz6-Os5UKSvhdyF6sUCasoobPf/view?usp=sharing */
