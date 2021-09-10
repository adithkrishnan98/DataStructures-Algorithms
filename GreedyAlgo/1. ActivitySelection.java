/*
Question :
Given N activities with their start and finish times. Get the maximum number of activities that can be performed by a single person, assuming that a person can 
only work on a single activity at a time. The start time and end time of two activities may coincide. Complete the function with arguments S[] & F[] and print the 
maximum activities which can be performed in new line.

Constraints:
1<=N<=1000
1<=A[i]<=100

Explanation : 
The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than or equal to the 
finish time of the previously selected activity. We can sort the activities according to their finishing time so that we always consider the next activity as 
minimum finishing time activity.

Steps :
1) Sort the activities according to their finishing time 
2) We increment count on the first activity from the sorted array as we include it first
3) For the remaining activities of the sorted array we check if the start time of this activity is greater than or equal to the finish time of the previously 
selected activity, if it is then select this activity and increment count again. 
4) Finally return the count of max activities that can be performed. 

*/

import java.util.*;
class Activity
{
  int start, finish;
 
  public Activity(int start, int finish)
  {
    this.start = start;
    this.finish = finish;
  }
}
 
// class to define user defined comparator
class Compare
{
 
  // A utility function that is used for sorting activities according to finish time
  static void compare(Activity arr[], int n)
  {
    Arrays.sort(arr, new Comparator<Activity>()
    {
        @Override
        public int compare(Activity s1, Activity s2)
        {
        return s1.finish - s2.finish;
        }
    });
  }
}
 
class ActivitySelection {

  static int printMaxActivities(Activity arr[], int n)
  {
    // Sort activities according to finish time
    Compare obj = new Compare();
    obj.compare(arr, n);
    
    int i = 0;
    int count = 0;
 
    // The first activity always gets selected
    count++;
 
    // Consider rest of the activities
    for (int j = 1; j < n; j++)
    {
      // If this activity has start time greater than or equal to the finish time of previously selected activity, then select it
      if (arr[j].start >= arr[i].finish)
      {
        count++;
        i = j;
      }
    }
    return count;
  }
 
  // Driver code
  public static void main(String[] args)
  {

    int n1 = 6;
    Activity arr1[] = new Activity[n1];
    arr1[0] = new Activity(1, 2);
    arr1[1] = new Activity(3, 4);
    arr1[2] = new Activity(2, 6);
    arr1[3] = new Activity(5, 7);
    arr1[4] = new Activity(8, 9);
    arr1[5] = new Activity(5, 9);
 
    int result1 = printMaxActivities(arr1, n1);
    System.out.println("Maximum activities performed : " + result1);

 
    int n2 = 4;
    Activity arr2[] = new Activity[n2];
    arr2[0] = new Activity(1, 2);
    arr2[1] = new Activity(3, 4);
    arr2[2] = new Activity(2, 3);
    arr2[3] = new Activity(5, 6);

    int result2 = printMaxActivities(arr2, n2);
    System.out.println("Maximum activities performed : " + result2);

  }
}

/*

Output :
Max activities performed : 4
Max activities performed : 4

Time Complexity : O(nlogn) since we have to sort the input array first 
Space Complexity : O(1) as we do not use any extra space

Video Link : https://drive.google.com/file/d/1hEYLGeGHGV-2GwuUkByp7jthfEu-brJW/view?usp=sharing

*/
