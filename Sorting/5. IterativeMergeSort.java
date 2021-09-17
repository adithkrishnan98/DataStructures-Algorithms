/*
Question : 
Implement iterative version of merge sort.

Explanation : 
In iterative merge sort we use the bottom up approach which means we start with 2 element sized array and we go up the ladder by sorting and then merging them. 
Next we take 4 element array, sort and merge them and so on until we get the entire array back in sorted order. In bottom up approach, since we don't exactly 
know unlike top down to spilt array exactly in the middle, we assume the array was divided by the powers of 2 so n/2, n/4 etc and also for an array size in 
powers of 2 like n = 2, 4, 8, 16 etc. 

So for other input sizes such as 5, 7, 11 we will have remaining sublist that didn’t go into the power of 2 width at each level as we keep on merging and go 
upwards, this unmerged sublist which is of size that is not exact power of 2, will remain isolated till the final merge.  To merge this unmerged list at final 
merge we need to force the mid to be at the start of unmerged list so that it is a candidate for merge. 

*/

public class IterativeMergeSort {
    static void mergeSort(int arr[], int n)
    {
         
        // For current size of subarrays to be merged curr_size varies from 1 to n/2
        int curr_size;
                     
        // For picking starting index of
        // left subarray to be merged
        int left_start;
                         
         
        // Merge subarrays in bottom up manner. First we merge subarrays of size 1 to create sorted subarrays of size 2, then merge subarrays of size 2 to create 
        // sorted subarrays of size 4, and so on.
        for (curr_size = 1; curr_size <= n-1;
                      curr_size = 2*curr_size)
        {
             
            // Pick starting point of different
            // subarrays of current size
            for (left_start = 0; left_start < n-1;
                        left_start += 2*curr_size)
            {
                // Find ending point of left subarray. mid+1 is starting point of right
                int mid = Math.min(left_start + curr_size - 1, n-1);
         
                int right_end = Math.min(left_start + 2*curr_size - 1, n-1);
         
                // Merge Subarrays arr[left_start...mid] & arr[mid+1...right_end]
                merge(arr, left_start, mid, right_end);
            }
        }
    }
     
    static void merge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        // create temp arrays 
        int L[] = new int[n1];
        int R[] = new int[n2];
     
        // Copy data to temp arrays L[] and R[]
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
     
        // Merge the temp arrays back into arr[l..r]
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
     
        // Copy the remaining elements of L[], if there are any 
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
     
        // Copy the remaining elements of R[], if there are any 
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
     
    public static void printArray(int arr[]){
        int n = arr.length;
        for(int i=0; i<n; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
        
     
    public static void main(String[] args)
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
     
        System.out.print("Given array is : ");
        printArray(arr);
     
        mergeSort(arr, n);
     
        System.out.print("Sorted array is : ");
        printArray(arr);
    }
}
/*
Output :
Given array is : 12 11 13 5 6 7
Sorted array is : 5 6 7 11 12 13 

Time Complexity : O(nlogn) as merge sort always divides the array into two halves and takes linear time to merge two halves.
Space Complexity : O(n) as we create a temp array to store sorted elements

Video Link : https://drive.google.com/file/d/1bAqz7by9CKRFVvKc9CAO6D6EWtTuXQ8s/view?usp=sharing
*/
