/*
Question : 
Given an Undirected Graph. Check whether it contains a cycle or not. Complete the method isCyclic() which takes the Graph and the number of vertices and edges as 
inputs and returns true if the given undirected graph contains any cycle. Else, it returns false. Its arguments are two integers 'N' and 'M' which denotes the 
no of vertices and no of edges respectively. And 'M’ pairs u and v denoting that there is an edge from u to v and returns 1 if there is a cycle else it should 
return 0.

Explanation : 
We can detect cycle in undirected graph using DFS (Depth First Search) technique. DFS is done for every unvisited vertex. A cycle is present in a graph if there 
is a back edge present in the graph. A back edge is an edge that is joining a node to itself or one of its ancestors in the tree produced by DFS. So in order to 
find the back edge we keep a visited array and if there is a back edge found to any visited node then a cycle is present and thus we return true. 

Steps :
a) Create a graph with given number of edges and vertices.
b) Create a recursive function isCyclic() that takes current vertex, visited array and a parent node. 
c) First we make the current node as visited. Then we find all vertices that are not visited and adjacent to the current node. We recursively call isCyclic() for those vertices. If it returns true, we return 1. 
d) Suppose the adjacent node is not a parent but is already visited then we return true. 
e) We create another function checkCyclic() which calls the isCyclic() function for all the vertices and if any of them return true, we return 1. If for all vertices it returns false, we return 0.

*/

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {  
   
    // Adjacency List Representation
    private LinkedList adjList[];
    private boolean visited[];
 
    // Constructor
    @SuppressWarnings("unchecked") 
    CycleInUndirectedGraph(int v){
        // Mark all the vertices as not visited and not part of recursion stack
        visited = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;
        
        adjList = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adjList[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adjList[v].add(w);
    }
 
    // A recursive function that uses visited[] and parent to detect cycle in subgraph reachable from vertex v.
    boolean isCyclic(int v, boolean visited[], int parent){
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices
        // adjacent to this vertex
        Iterator it = adjList[v].iterator();
        while(it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not visited, then recur for that adjacent
            if (!visited[i])
            {
                if (isCyclic(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited and not parent of current vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    int checkCyclic(int v){
        // Call the recursive helper function to detect cycle in different DFS trees
        for (int u = 0; u < v; u++)
        { 
            // Don't recur for u if already visited
            if (!visited[u])
                if (isCyclic(u, visited, -1))
                    return 1;
        }
        return 0;
    }
 
 
    // Driver method to test above methods
    public static void main(String args[])
    {
         
        // Create a graph given
        // in the above diagram
        CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        g1.addEdge(4, 2);
        
        System.out.println(g1.checkCyclic(5));
 
        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.checkCyclic(3));
    }
}

/*
Output :
1
0

Time Complexity : O(V + E) as we are doing DFS traversal using adjacency list where V is number of vertices and E is number of edges in graph. 

Space Complexity : O(V) as we are creating a visited array with length equal to number of vertices.

Video Link : https://drive.google.com/file/d/1VV9D5P78Rbpip8JDCAEAS_ry-VGr60bm/view?usp=sharing

*/
