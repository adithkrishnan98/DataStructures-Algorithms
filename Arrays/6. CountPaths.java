/* Question :
The problem is to count all the possible paths from the top left element to the bottom right element of an MxN matrix with the constraint of going ONLY 
right or down fom each cell. You will have to create the matrix on your own.
Implement a method numPaths(m,n) which take M and N, M meaning number of rows and N meaning number of columns and return the number of paths. 
Check for the constraint in your function - 1 ≤ M,N ≤ 10 and return -1 for incorrect arguments.

Explanation :
We can solve the above problem using recursion. Let's say we have a 3x3 matrix, we need to travel from 0,0 to 2,2 with constraints of only going right or down. 
This means that the row and column can only be incremented and not decremented to reach the goal. 
Intuitively calculating the number of paths in a 3x3 matrix we get, 

(0,0) --> (0,1) --> (0,2) --> (1,2) --> (2,2)
(0,0) --> (1,0) --> (2,0) --> (2,1) --> (2,2)
(0,0) --> (0,1) --> (1,1) --> (2,1) --> (2,2)
(0,0) --> (0,1) --> (1,1) --> (1,2) --> (2,2)
(0,0) --> (1,0) --> (1,1) --> (1,2) --> (2,2)
(0,0) --> (1,0) --> (1,1) --> (2,1) --> (2,2)

= 6 paths. 

For any given recursive solution, there will have to be a base case to be defined. In this problem, the base case is when m == 1 and n == 1 then we return 1 
as number of paths. Below is the code implementation 
*/

public class Paths {
    static int numPaths(int row, int col){
        if(row <= 0 || col <= 0){
            return -1;
        }
        else if(row >= 10 || col >= 10){
            return -1;
        }
        else if(row == 1 || col == 1){
            return 1;
        }
        return numPaths(row-1, col) + numPaths(row, col-1);

    }
        
    public static void main(String[] args) {
        System.out.println(numPaths(3,3));
        System.out.println(numPaths(2,4));
        System.out.println(numPaths(3,-2));
        System.out.println(numPaths(10,13));
    }
}

/*
Output :
6
4
-1
-1

Time Complexity : O(n^2) as we have a case of overlapping subproblems in the recursive equation. For example as explained in the video, we are calculating 
the result of numPaths(2,2) twice instead of once for a 3x3 matrix. As this matrix increases, there will be many more such overlapping subproblems which 
thus push the time complexity to exponential. We can get a better time complexity by applying dynamic programming.
Space Complexity : O(1) as no extra space is being used.

Video Explanation : https://drive.google.com/file/d/1DynzOKBaVrD4fUpOXfStA8-9ExCuBAvA/view?usp=sharing
*/
