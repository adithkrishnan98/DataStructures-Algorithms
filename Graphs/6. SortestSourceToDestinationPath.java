/*
Question : 
Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path, print the minimum no of steps needed to reach 
it, else print -1 if the destination is not reachable. You may move in only four direction ie up, down, left and right. The path can only be created out of a cell 
if its value is 1. Complete the function for implementing this. Arguments are two integers n and m denoting the size of the matrix, an n*m matrix and two integers x and y denoting 
the index of the destination. Print the min no of steps needed to reach the destination.

Constraints:
1<=n,m<=20

Explanation : 
We can solve this problem using Lee's Algorithm. It follows the Breath First Search (BFS) approach. 
Steps :
a) Create an empty queue and enqueue the source cell having a distance 0 from the source (itself) and mark it as visited. 
b) Loop till queue is empty and do the following :
       i) Dequeue the front node
       ii) If the popped node is the destination node, then return its distance
       iii) Otherwise, for each of the four adjacent cells of the current cell, enqueue each valid cell with +1 diatance and mark them as visited
c) If all the queue nodes are processed and the destination is not reached, then return -1.

Note tht in BFS, all cells having the shortest path as 1 are visited first, followed by their adjacent cells having the shortest path as 1 + 1 = 2 and so on.. 
So if we reach any node in BFS, its shortest path is one more than the shortest path of the parent. So, the destination cell's first occurance gives us the 
result and we can stop our search there. It is impossible that the shortest path exists from some other cell for which we haven't reached the given node yet. 
If such path were possible, we would have already explored it.  

*/

import java.util.ArrayDeque;
import java.util.Queue;

class Node
{
    // (x, y) represents matrix cell coordinates, and dist represents their minimum distance from the source
    int x, y, dist;
 
    Node(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class ShortestSourceToDestinationPath {
    // M × N matrix
    private static final int M = 3;
    private static final int N = 4;
 
    // Below arrays detail all four possible movements from a cell(left, up, right, down)
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };
 
    // Function to check if it is possible to go to position (row, col) from the current position. The function returns false if (row, col) is not a valid position or has a value 0 or already visited.
    private static boolean isValid(int mat[][], boolean visited[][], int row, int col)
    {
        return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
    }
 
    // Find the shortest possible route in a matrix mat from source cell (i, j) to destination cell (x, y)
    private static void BFS(int mat[][], int i, int j, int x, int y)
    {
        // construct a matrix to keep track of visited cells
        boolean[][] visited = new boolean[M][N];
 
        // create an empty queue
        Queue q = new ArrayDeque<>();
 
        // mark the source cell as visited and enqueue the source node
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
 
        // stores length of the longest path from source to destination
        int min_dist = Integer.MAX_VALUE;
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and process it
            Node node = q.poll();
 
            // (i, j) represents a current cell, and dist stores its minimum distance from the source
            i = node.x;
            j = node.y;
            int dist = node.dist;
 
            // if the destination is found, update min_dist and stop
            if (i == x && j == y)
            {
                min_dist = dist;
                break;
            }
 
            // check for all four possible movements from the current cell and enqueue each valid movement
            for (int k = 0; k < 4; k++)
            {
                // check if it is possible to go to position (i + row[k], j + col[k]) from current position
                if (isValid(mat, visited, i + row[k], j + col[k]))
                {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }
 
        if (min_dist != Integer.MAX_VALUE)
        {
            System.out.println(min_dist);
        }
        else {
            System.out.print(-1);
        }
    }
 
    public static void main(String[] args)
    {
        // input maze
        int[][] mat =
        {
            { 1, 0, 0, 0},
            { 1, 1, 0, 1},
            { 0, 1, 1, 1}
        };
 
        // Find the shortest path from source (0, 0) to destination (7, 5)
        BFS(mat, 0, 0, 2, 3);
    }
}

/*
Output :
5

Time Complexity : O(M x N) where M and N are dimensions of the matrix
Space Complexity : O(M x N) used to create the visited array of size M x N

Video Link : https://drive.google.com/file/d/1pVntE8z3aEEPI0NHxmkFOBBvHv-di4m0/view?usp=sharing
*/
