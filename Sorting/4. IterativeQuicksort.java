/*
Question :
Implement the iterative version of quicksort.

Explanation :
In this method of quicksort, it works exactly the way that the recursive version does. The only difference is that in the iterative version the stack is managed 
explicitly rather than depending on the implicit stack in the recursive version. The partition function remains the same here and instead of recursively calling 
quicksort, we use an auxillary stack to push the low and high values in and call quicksort on those repeatedly until the stack is empty. Below is the 
implementation. 

*/

public class IterativeQuicksort {
    
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
 
        // index of smaller element
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            // we check if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
 
        return i + 1;
    }
 
    static void quickSortIterative(int arr[], int l, int h)
    {
        // Create an auxiliary stack
        int[] stack = new int[h - l + 1];
 
        // initialize top of stack
        int top = -1;
 
        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;
 
        // Keep popping from stack while is not empty
        while (top >= 0) {
            // Pop h and l
            h = stack[top--];
            l = stack[top--];
 
            int p = partition(arr, l, h);
 
            // If there are elements on left side of pivot, then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
 
            // If there are elements on right side of pivot, then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
    public static void main(String args[])
    {
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 };
        int n = 8;
 
        quickSortIterative(arr, 0, n - 1);
 
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
Output :
1 2 2 3 3 3 4 5 

Time Complexity : O(nlogn) as in the first partitioning pass, we split array into two partitions. That takes O(n). In the next pass we have two partitions, each 
of which is of size n/2. It takes O(n/2) to partition each of those. Total time for the second pass is O(n/2 + n/2): O(n). Each pass has more partitions, but the 
partitions are smaller. Therefore in total, we make log(n) passes, each of which requires O(n) total time. Hence the time complexity is O(nlogn). 

Space Complexity : O(n) as we are creating and using a auxillary stack 

Video Link : https://drive.google.com/file/d/1r5PM84s87QfJIZKO37aqRM895bKKbloi/view?usp=sharing 
*/
