package Problems.Arrays;

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
