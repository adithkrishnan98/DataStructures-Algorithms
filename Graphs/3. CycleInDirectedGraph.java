/*
Question : 
Given a Directed Graph. Check whether it contains any cycle or not. Complete the method isCyclic() which takes the Graph and the number of vertices as inputs and 
returns true if the given directed graph contains any cycle. Else, it returns false. Its arguments are two integers 'N' and 'M' which denotes the no of vertices 
and no of edges respectively. And 'M’ pairs u and v denoting that there is an undirected edge from u to v and return 1 if there is a cycle else it should return 0.

Explanation : 
Here again we can use DFS to find out presence of cycle in a graph. DFS for a connected graph produces a tree. To detect cycle, we need to check for back edges. 
To detect a back edge, we keep track of the vertices currently in the recursion stack of the function for DFS traversal using a recStack[] array. If a vertex 
reached is already in the recursion stack, then there is a cycle in the tree. The edge that connects the current vertex to the vertex in the recursion stack is 
the back edge. 

Steps :
a) Create a graph with given number of edges and vertices.
b) Create a recursive function isCyclic() that takes current vertex, visited array and a parent node. 
c) We mark the current node as visited and also mark the index in recursion stack. 
d) Then we find all vertices that are not visited and adjacent to the current node. We recursively call isCyclic() for those vertices. If it returns true, we return 1. 
e) If adjacent vertices are already marked in the recursion stack then we return true. 
e) We create another function checkCyclic() which calls the isCyclic() function for all the vertices and if any of them return true, we return 1. If for all vertices it returns false, we return 0.

*/

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInDirectedGraph {
// Adjacency List Representation
private LinkedList adjList[];
private boolean visited[];
private boolean recStack[];

// Constructor
@SuppressWarnings("unchecked") 
CycleInDirectedGraph(int v){
    // Mark all the vertices as not visited and not part of recursion stack
    visited = new boolean[v];
    recStack = new boolean[v];
    
    adjList = new LinkedList[v];
    for(int i=0; i<v; ++i)
        adjList[i] = new LinkedList(); 
}

// Function to add an edge into the graph
void addEdge(int v,int w)
{
    adjList[v].add(w);
}

// check if cycle is present or not
boolean isCyclic(int v, boolean visited[], boolean recStack[]){
    if (recStack[v])
    return true;

    if (visited[v])
        return false;
        
    visited[v] = true;

    recStack[v] = true;
    Iterator it = adjList[v].iterator();
        while(it.hasNext())
        {
            int i = it.next();

            if (isCyclic(i, visited, recStack)){
                return true;
            }
 
            recStack[i] = false;
        }
        return false;
}

int checkCyclic(int v){
    // check for cycle in every vertex
    for (int u = 0; u < v; u++)
    {
        if (isCyclic(u, visited, recStack)){
            return 1;
        }
    }
    return 0;
}


public static void main(String args[]){

    CycleInDirectedGraph g1 = new CycleInDirectedGraph(4);
    g1.addEdge(0, 1);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(2, 0);
    g1.addEdge(2, 3);
    g1.addEdge(3, 3);
    
    System.out.println(g1.checkCyclic(5));

    CycleInDirectedGraph g2 = new CycleInDirectedGraph(3);
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

Video Link : https://drive.google.com/file/d/1cXkbs6F8Gzopz4cq8B4qomcWjFQyYrw8/view?usp=sharing

*/
