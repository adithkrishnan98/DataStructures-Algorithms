/*
Question : 
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room? Complete the function which takes the array containing the starting time of 
all the meetings S [ i ] and the array containing the finishing time of all the meetings F [ i ].

Print the order in which the meetings take place separated by a space.

Constraints:
1 ≤ N ≤ 100
1 ≤ S[ i ], F[ i ] ≤ 100000

Explanation : 
In this problem, we need to get the maximum number of meetings that can occur in a single room. So it is a maximization problem and thereby an optimization 
problem. Such optimization problems can be solved using greedy approach. The greedy choice is to always pick the next meeting whose finish time is least among the 
remaining meetings and the start time is more than or equal to the finish time of the previously selected meeting. We can sort the meetings according to their 
finishing time so that we always consider the next meeting as minimum finishing time meeting.

Steps :
1) Sort the meetings according to their finishing time 
2) Select the first meeting from the sorted array and print it. 
3) Do the following for the remaining meetings in the sorted array. 
    a) If the start time of this meeting is greater than or equal to the finish time of the previously selected meeting, then select this meeting and print it. 

*/

import java.util.Arrays;
import java.util.Comparator;


class Comparison {
    static void compare(Integer arr[], int n)
    {
      Arrays.sort(arr, new Comparator()
    {
        @Override
        public int compare(Integer s1, Integer s2)
        {
            return s1 - s2;
        }
    });
    }
}

public class NMeetingsINOneRoom {
    
    static void findMaxMeetings(Integer [] start, Integer [] finish, int n){
        Comparison.compare(finish, n);
        Integer i, j;
        i = 0;
        System.out.println("Following meetings are possible :");
        System.out.print(i+1 + " ");

        for(j = 1; j<n; j++){
            if(start[j] >= finish[i]){
                System.out.print(j+1 + " ");
                i = j;
            }
        }
    }

    public static void main(String[] args) {
        Integer [] start = {1,3,0,5,8,5};
        Integer [] finish = {2,4,6,7,9,9};
        Integer n = finish.length;
        findMaxMeetings(start, finish, n);
    }
}

/*

Output :
1 2 4 5

Time Complexity : O(nlogn) if array is not sorted and O(n) if array comes sorted.
Space Complexity : O(1) as we do not utilise any extra space. 

Video Link : https://drive.google.com/file/d/1OhHsu6TeSf92TgzGJ79eibsnImz-9V2G/view?usp=sharing

*/
