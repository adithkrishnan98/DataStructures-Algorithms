package Problems.Arrays;

import java.util.Arrays;

// Given an array of n integers where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets such that:
//    - Each student gets one packet.
//    - The difference between the number of chocolates in the packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
// Implement a method chocolateDistribuite(c[], m) and print the minimum difference.
// Constraints :
// 1 <= A[i] <= 10^18
// 1 <= M <= length of A

public class chocolateDist {

    static int chocolateDistribute(int[]c, int m){ 
        if (m == 0 || c.length == 0){
            return 0;  
        }
        if(m > c.length ){
            return -1;
        }
        Arrays.sort(c); 
        int min_diff = Integer.MAX_VALUE;
        for(int i = 0; i+m-1<c.length; i++){
            int difference = c[i+m-1] - c[i] ;
            if (difference < min_diff) {
                min_diff = difference;
            }
        }
        return min_diff; 
    }
    public static void main(String[] args) {
        // int[] a = {3, 4, 1, 9, 56, 7, 9, 12};
        int[] a = {7,3,2,4,9,12,56};
        int m = 3;
        System.out.println(chocolateDistribute(a, m)); 
    }
}
