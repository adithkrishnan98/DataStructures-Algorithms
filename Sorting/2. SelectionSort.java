/*
Question : 
Implement selection sort.

Explanation :
In this, we take the first position, find the minimum value’s index from the entire array and then swap it with that first element. Then we take the 2nd position, 
again find the min in n-1 elements and swap it with the 2nd element and so on. We do this operation till the last, even if the array becomes sorted in between 
this process. Selection sort is an inplace algorithm. 

*/

class SortingAlgos{
    
    int findMinIndex(int [] arr, int start, int end){
        int min_index = start;
        for(int i = start + 1; i<end; i++){
            if(arr[i] < arr[min_index]){
                min_index = i;
            }
        }
        return min_index;
    }
    void selectionSort(int [] arr){
        for(int i = 0; i<arr.length; i++){
            int index = findMinIndex(arr, i, arr.length);
            if(i!=index){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }
    
    void printArray(int [] arr){
        for(int n : arr){
            System.out.print(n + " ");
        }
    }
    
    public static void main (String[] args) {
        SortingAlgos sort = new SortingAlgos();
        int [] array = {2, 5, 6, 9, 2, 1, 4, 7};
        sort.selectionSort(array);
        sort.printArray(array);
    }
}
/*
Output :
1 2 2 4 5 6 7 9

Time complexity = O(n^2) as total iterations = (n-1) + (n-2) + …+ 1 = (n (n-1))/2 = n^2
Space complexity = O(1) as no extra space is being used

Video Link : https://drive.google.com/file/d/16iNnHKDMHkkN8x9LV6AZ7ST-sUyE0SmJ/view?usp=sharing
*/
