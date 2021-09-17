/*
Question :
Implement bucket sort.

Explanation : 
Bucket Sort is a sorting algorithm that divides the unsorted array elements into several groups called buckets. Each bucket is then sorted by using any of the 
suitable sorting algorithm or recursively applying the same bucket algorithm. Finally, the sorted buckets are combined to form a final sorted array. Bucket sort 
is used if we have the input that is uniformly distribuited over a range like say age of people from 10 - 30, weights and height of people etc. It is also very 
easy to sort floating point numbers uniformly distribuited over a range. merge, heap and quicksort - O(nlogn), count sort cannot be applied as the keys used as 
index are all floats and not integers. 

*/

import java.util.Collections;
import java.util.LinkedList;

public class SortingAlgos {
    private void bucketSort(float[] arr, int k) {
        if(k<=0){
            return;
        }
        @SuppressWarnings("unchecked")
        LinkedList buckets [] = new LinkedList [k];
        
        // Create empty buckets
        for(int i=0; i<k; i++){
            buckets[i] = new LinkedList();
        }

        // Add elements into the buckets
        for(int i = 0; i<arr.length; i++){
            float index = arr[i] * k;
            buckets[(int)index].add(arr[i]);
        }

        // Sort the elements of each bucket
        for(int i = 0; i<k; i++){
            Collections.sort(buckets[i]);
        }

        // Get the sorted array
        int index = 0;
        for(int i = 0; i<k; i++){
            for(int j = 0; j<buckets[i].size(); j++){
                arr[index] = buckets[i].get(j);
                index++;
            }
        }
    }

    
    void printArray(float arr[]){
        for(float i : arr){
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        SortingAlgos obj = new SortingAlgos();
        float arr[] = { (float) 0.42, (float) 0.32, (float) 0.33, (float) 0.52, (float) 0.37, (float) 0.47,
            (float) 0.51 };
        int n = arr.length;
        obj.bucketSort(arr, n);
        System.out.print("Sorted array : ");
        obj.printArray(arr);
    }
}

/*
Output :
Sorted array : 0.32 0.33 0.37 0.42 0.47 0.51 0.52 

Time Complexity : O(n + k) where n is length of elements 
Space Complexity : O(nk) as we use linked list to create the buckets thereby using extra space

Video Link : https://drive.google.com/file/d/1ajyVSLbe61ItaAeJKIcx0MLFRFOQxo1O/view?usp=sharing
*/
