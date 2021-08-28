package Problems.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class RelativeSorting {
    
    void sortRelatively(int [] arr1, int [] arr2){
        
        // first sort the array
        Arrays.sort(arr1); //O(nLogn)

        // create hashmap and put keys as elements of the array and values as their counts 
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        for(int i = 0; i<arr1.length; i++){ // O(n)
            int counter = 0;
            // we check if value already present, if it is we increment counter else we put the new value
            if(hM.containsKey(arr1[i])){
                counter = hM.get(arr1[i]);
            }
            hM.put(arr1[i], counter+1);
        }

        // create an output array
        ArrayList<Integer> output = new ArrayList<Integer>();

        // for each element in arr2, if it is present in arr1 add it to the output list, its value (count) number of times. Remove elements from the hashmap once added
        for(int j = 0; j<arr2.length; j++){ //O(n)
            if(hM.containsKey(arr2[j])){
                output.addAll(Collections.nCopies(hM.get(arr2[j]), arr2[j]));
                hM.remove(arr2[j]);
            }
        }

        // loop through elements in arr1 and check if present in hashmap, and similarly add them to the output array 
        for(int n = 0; n<arr1.length ; n++){ //O(n)
            if(hM.containsKey(arr1[n])){
                output.addAll(Collections.nCopies(hM.get(arr1[n]), arr1[n]));
            }
        } 

        // print the elements of the output array
        for(int n : output){ //O(n)
            System.out.print(n + " ");
        }

    }

    // Driver Code
    public static void main(String[] args) {
        RelativeSorting sort = new RelativeSorting();
        int [] arr1 = {2,1,2,5,7,1,9,3,6,8,8};
        int [] arr2 = {2,1,8,3};

        sort.sortRelatively(arr1, arr2);

        System.out.println();

        int [] arr3 = {2,6,7,5,2,6,8,4};
        int [] arr4 = {2,6,4,5};

        sort.sortRelatively(arr3, arr4);
    }
}
