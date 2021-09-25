/*
Question :
Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top 
left cell to bottom right cell by which total cost incurred is minimum. You can move in 4 directions : up, down, left and right. It is assumed that negative cost 
cycles do not exist in input matrix. N denotes the size of the grid N*N integer matrix depicting the cost of respective cell from (0,0) to (N,N). Output a single 
integer depicting the minimum cost to reach the destination.

Constraints:
1 <= N <= 100
1 <= grid[i][j] <= 104

Explanation:
We solve this problem using dijkstra's algorithm. Each cell of grid represents a vertex and neighbor cells adjacent vertices. We do not make an explicit graph 
from these cells instead we will use matrix as it is in our dijkstra’s algorithm. 

a) Create an empty priorityqueue with a distanceComparator and enqueue the source cell and put its distance in dist array. Initially dist array is initialised with 
all values as Integer.MAX_VALUE.  
b) We Loop till queue is empty and do the following :
       i) Dequeue the front node
       ii) We check in all 4 directions of the popped node for the minimum cost and then if it is not already reached. If it is reached we remove it from the queue 
       else we insert this cell in the priority queue and also update the distance.  
c) We repeat the same process until we reach end of matrix. 

*/

import java.io.*;
import java.util.*;

public class MinimumCostPath {
// Below arrays detail all four possible movements from a cell (left, top, right, bottom)
static int[] row = { -1, 0, 1, 0 };
static int[] col = { 0, 1, 0, -1 };
 

static class Node
{
    int x;
    int y;
    int distance;
     
    Node(int x, int y, int distance)
    {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
 
// Custom comparator for inserting cells into Priority Queue
static class distanceComparator implements Comparator
{
    public int compare(Node a, Node b)
    {
        if (a.distance < b.distance)
        {
            return -1;
        }
        else if (a.distance > b.distance)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
}
 
// Utility method to check whether current cell isValid or not
static boolean isValid(int i, int j, int M, int N)
{
    return (i >= 0 && i < M && j >= 0 && j < N);
}
 
// Method to return shortest path from top-corner to bottom-corner in 2D grid
static int shortestPath(int[][] grid, int M, int N)
{
    int[][] dist = new int[M][N];
     
    // Initializing distance array by INT_MAX
    for(int i = 0; i < M; i++)
    {
        for(int j = 0; j < N; j++)
        {
            dist[i][j] = Integer.MAX_VALUE;
        }
    }
     
    // Initialized source distance as initial grid position value
    dist[0][0] = grid[0][0];
     
    PriorityQueue pq = new PriorityQueue(M * N, new distanceComparator());
                   
    // Insert source cell to priority queue
    pq.add(new Node(0, 0, dist[0][0]));
    while (!pq.isEmpty()){

        Node curr = pq.poll();
        for(int i = 0; i < 4; i++){

            int R = curr.x + row[i];
            int C = curr.y + col[i];
             
            if (isValid(R, C, M, N)){

                if (dist[R][C] > dist[curr.x][curr.y] + grid[R][C]){
                     
                    // If Node is already been reached once, remove it from priority queue
                    if (dist[R][C] != Integer.MAX_VALUE)
                    {
                        Node adj = new Node(R, C, dist[R][C]);
                        pq.remove(adj);
                    }
                     
                    // Insert cell with updated distance
                    dist[R][C] = dist[curr.x][curr.y] + grid[R][C];
                                        
                    pq.add(new Node(R, C, dist[R][C]));
                }
            }
        }
    }
    return dist[M - 1][N - 1];
}
 
public static void main(String[] args) throws IOException{
    int[][] grid = { { 31, 100, 65, 12, 18 },
                     { 10, 13, 47, 157, 6 },
                     { 100, 113, 174, 11, 33 },
                     { 88, 124, 41, 20, 140 },
                     { 99, 32, 111, 41, 20 } };
                      
    System.out.println(shortestPath(grid, 5, 5));

    int[][] grid2 = {{ 42, 93},
                     { 7, 14}};
                      
    System.out.println(shortestPath(grid2, 2, 2));
    }
}

/*

Output : 
327
63

Time Complexity : 
Space Complexity : O(M x N) used to create the dist array of size M x N

Video Link : https://drive.google.com/file/d/1XdqLVARt7xd6D4hTk0v7DNkr-j27MR-p/view?usp=sharing
*/
