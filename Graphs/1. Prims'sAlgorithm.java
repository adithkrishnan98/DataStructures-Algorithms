/*
Question : 
Find the minimum spanning tree in a graph using Prim's algorithm. Create a method primsMST() which will take the adjacency matrix of the graph as an argument and 
print a minimum spanning tree of the graph. 
Expected Time Complexity : O(V^2)

Explanation : 
Prim's algorithm is a minimum spanning tree algorithm that takes a graph as input and finds the subset of the edges of that graph which forms a tree inclusive of 
all vertices and has minimum sum of weights among all the trees that can be formed from the graph. A spanning tree is a sub-graph of an undirected connected 
graph, which includes all the vertices of the graph with a minimum possible number of edges. A minimum spanning tree is a spanning tree in which the sum of the 
weight of the edges is as minimum as possible.

The total number of spanning trees with n vertices that can be created from a complete graph is equal to n(n-2).
For eg : If we have n = 4, the maximum number of possible spanning trees is equal to 44-2 = 16. Thus, 16 spanning trees can be formed from a complete graph with 
4 vertices.

Steps :
a) Initialise the minimum spanning tree with a vertex chosen at random
b) Find all the edges that connect the tree to new vertices and find the minimum amongst them and add it to the tree.
c) Step 2 is repeated until we get s minimum spanning tree. 

*/

import java.util.Arrays;

public class PrimsAlgorithm {
    public void PrimsMST(int[][] G, int V) {
    
        int edge_count; // number of edge
    
        // create a array to track visited vertex. visited will become true otherwise false
        boolean[] visited = new boolean[V];
    
        // set visited false initially
        Arrays.fill(visited, false);
    
        // set number of edge to 0
        edge_count = 0;
    
        // the number of edge in minimum spanning tree will be always less than (V -1), where V is number of vertices in graph
    
        // choose 0th vertex and make it true
        visited[0] = true;
    
        // print for edge and weight
        System.out.println("Edge : Weight");
    
        while (edge_count < V - 1) {
    
          int min = Integer.MAX_VALUE;
          int x = 0; // row number
          int y = 0; // col number
    
          for (int i = 0; i < V; i++) {
            if (visited[i] == true) {
              for (int j = 0; j < V; j++) {
                // not in visited and there is an edge
                if (!visited[j] && G[i][j] != 0) {
                  if (min > G[i][j]) {
                    min = G[i][j];
                    x = i;
                    y = j;
                  }
                }
              }
            }
          }
          System.out.println(x + " - " + y + " :  " + G[x][y]);
          visited[y] = true;
          edge_count++;
        }
      }
    
      public static void main(String[] args) {
        PrimsAlgorithm g = new PrimsAlgorithm();
    
        // number of vertices in graph
        int V = 5;
    
        // create a 2d array of size 5x5 for adjacency matrix to represent graph
        int[][] G = { { 0, 2, 0, 6, 0 },
                      { 2, 0, 3, 8, 5 },
                      { 0, 3, 0, 0, 7 },
                      { 6, 8, 0, 0, 9 },
                      { 0, 5, 7, 9, 0 } 
      };
      
        g.PrimsMST(G, V);
      }
}

/*
Output : 
Edge : Weight
0 - 1 : 2
1 - 2 : 3
1 - 4 : 5
0 - 3 : 6

Time Complexity : O(V2) since we are having nested for loops looping each time through V number of vertices
Space Complexity : O(V) since we are creating a visited arraywith length equal to number of vertices. 

Video Link : https://drive.google.com/file/d/1pBwbBBOzdC7xFpW_edPmFbpBVK_pvjJz/view?usp=sharing

*/
