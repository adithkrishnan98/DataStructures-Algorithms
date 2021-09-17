/*
Question :
Implement Insertion sort.

Explanation : 
Insertion sort works similarly as we sort cards in our hand in a card game. We assume that the first card is already sorted then, we select an unsorted card. If 
the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left. In the same way, other unsorted cards are taken and put in 
their right place. This happens over and over until all cards are sorted. This same approach is taken by insertion sort algorithm. The second element in an array 
is taken as key and there is a pointer at the first element. We compare both these elements, if key is lesser than first element then we place it to the left of 
the first element else we keep it where it remains. Below is the code implementation for the same.

*/
lass SortingAlgos{
    
    void insertionSort(int [] arr){
        int n = arr.length;
        for(int i = 1; i<n; i++){
            int j = i - 1;
            int key = arr[i];
            while(j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
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
        sort.insertionSort(array);
        sort.printArray(array);
    }
}
/*
Output :
1 2 2 4 5 6 7 9

Time Complexity : O(n^2) 
Number of iterations that may occur in worst case is for the number of items on the list which can be n items. And the number of swaps that can occur in the 
worst case can be n-1 swaps as the smallest element can be in the very end and needs to be shifted all the way to the start. So the total time complexity would 
be O(n^2)

Space Complexity : O(1) as no extra space is being used

Video Link : https://drive.google.com/file/d/1spfsTB9az9jWWQk_PQc4JxYqbDMeC82n/view?usp=sharing
*/
