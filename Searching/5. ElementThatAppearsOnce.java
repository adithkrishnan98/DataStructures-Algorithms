/*
Question :
Given a sorted array A, size N, of integers; every element appears twice except for one. Find that element that appears once in array. Complete the function 
whose argument is the array and prints the number that appears only once in the array.

Constraints:
1 ≤ N ≤ 107">107107
0 ≤ A[i] ≤ 1017">1017

Explanation :
In this problem the first way to think of solution would be by using two pointers i and j. We keep j at 0 and i at 1 and we check if the elements are equal. If 
they are we increment i and j each by 2 and check again. As long as the elements are equal we keep incrementing i and j by 2 and moving ahead. If they are not 
equal, we print out jth element which is the required element that appears only once. This takes O(n) time complexity. 

Another better approach is to use binary search. An observation that can be made from the given array is that the first occurance of an element before the 
required element is at even index while the next occurance is at odd index. But after the required element, the first occurance is at odd index while the 
second occurance is at even index. Therefore, we find the middle index and then if it is even, we check if it is equal to its next index. If it is then the 
required element lies on the right side else it lies on the left side of the middle. Similarly, if the middle index is odd, then we check itself and the 
previous element if they are equal. If they are then the required element is present to the right of the middle else it's present to the left. This approach 
takes O(logn) time since we are applying binary search. 

*/

public class ElementAppearsOnce {

    public static void search(int[] arr, int low, int high)
    {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is " + arr[low]);
            return;
        }
 
        // Find the middle point
        int mid = (low + high) / 2;
 
        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
                search(arr, mid + 2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high);
            else
                search(arr, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,3,4,50,50,65,65};
        search(arr, 0, arr.length-1);
    }
}

/*

Output :
4

Time Complexity : O(logn) since we are applying binary search. 
Space Complexity : O(1) as we are not utlising any extra space

Video Link : https://drive.google.com/file/d/1izVW8Fn7WJCEQxxRdPii_hd4FKlUONIh/view?usp=sharing

*/
