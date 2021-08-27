/* Question :
Given an array of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all 
the elements to its right side. Also, the rightmost element is always a leader. Complete the function which takes the elements of the array and prints all the 
leaders.

Constraints:
1 <= N <= 107
0 <= Ai <= 107

Explanation :
In the brute force approach, we can have nested for loops. The outer loop starts picking element from 0 while inner loop picks from 1. We compare the two elements 
and check if the left element is lesser or greater than right. if it is lesser then we break the inner loop and move on to the next element in the outer loop. 
But if it is greater we keep moving the inner loop to the next element. Once the inner loop reaches the length of the array it means the loop has not broken 
anywhere. This means the element on the left is greater than or equal to all of its elements on the right. Thus we print it. We then move on to the next element 
of the outer loop and do the same thing. This approach has a time complexity of O(n^2). 

A more efficient method would be to start from the end of the array. Since it is said that the right most element is always the leader we pick that as the 
max element and print it first. Then we traverse the array from the end and check if there are elements greater than or lesser than this max element. 
If there are elements greater we set that element as max and print it out. We do the same for the entire length of the array. This approach uses only a single 
for loop and thus is more efficient with a time complexity of O(n). 


O(N^2) TIME COMPLEXITY SOLUTION
class LeadersInArray{
   
    void printLeaders(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int j;
            for(j = i + 1; j < arr.length; j++){
                if (arr[i] <=arr[j]){
                    break;
                }
            }
            if (j == arr.length){ // loop did not break
                System.out.print(arr[i] + " ");
            } 
        }
    }

    public static void main(String[] args){
        LeadersInArray lead = new LeadersInArray();
        int arr[] = new int[]{1, 2, 3, 4, 0};
        lead.printLeaders(arr);
    }
}
*/

// O(N) TIME COMPLEXITY SOLUTION
class LeadersInArray {

    void printLeaders(int [] arr){
        int max_from_right = arr[arr.length - 1];
        System.out.print(max_from_right + " ");

        for(int i = arr.length-2; i>=0; i--){
            if(max_from_right < arr[i]){
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }
    }

    public static void main(String[] args) {
        LeadersInArray lead = new LeadersInArray();
        int arr[] = {16, 17, 4, 3, 5, 2};
        int arr2[] = {1, 2, 3, 4, 0};
        lead.printLeaders(arr);
        lead.printLeaders(arr2);
    }
}

/* 
Output :
2 5 17
0 4

Time Complexity : O(n) as we use a single for loop to loop through n elements in the array
Space Complexity : O(1) as we do not utlise any extra space

Video Explanation : https://drive.google.com/file/d/1jHYygnvtLGLYQfVI0LVGvjH5XonzUZzn/view?usp=sharing
*/

