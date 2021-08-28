/* 
Question :
Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as 
those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or 
equal to number of elements in A1[] andA2[] has all distinct elements.

Expected time complexity is O(N log(N)).

Length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.

Constraints:
1 ≤ A1[], A2[] <= 10^6

Explanation :
We can use hashing technique to solve this problem. We first sort the arr1 using Arrays.sort(). Next, we create a hashMap with keys as elements of the arr1 
and values as their counts. We loop through arr1 and store count of every number in the hashMap. Next, we loop through arr2 and check if the element is present 
in hashmap, if it is then we put it in the output array that many number fo times and remove the element from the hashMap. Finally, we loop through the arr1 
again and add the rest of the elements to the end of the output array in sorted order and we print the output array. 

*/

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

/* 
Output :
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8

Time Complexity : O(nLogn). The Arrays.sort() method takes O(nLogn) to sort the array. The rest of the for loops each take O(n) time individually so a total of 
all of them would still be O(n). So we have O(nLogn + n) time complexity, since the former is the larger term the overall time complexity would be O(nLogn).
Space Complexity : O(n) as we use extra space to create hash map and output array. 

Video Explanation : https://drive.google.com/file/d/1yh61hrBBfNwgCPQCdBbBVIdj2csFzw4r/view?usp=sharing

*/
