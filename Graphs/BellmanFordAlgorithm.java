/*
Question : 
Implement the Bellman Ford Algorithm to find Shortest paths to all vertices from a single source. Given a graph and a source vertex src in graph, find shortest 
paths from src to all vertices in the given graph. The graph may contain negative weight edges. If there is a negative weight cycle then print -1

Expected Time Complexity- O(VE)

Explanation : 
Bellman-Ford algorithm is used to find shortest distance to all vertices when there are negative weights in a graph. Dijkstra’s algorithm, which is a Greedy 
algorithm. Dijkstra doesn’t work for Graphs with negative weight edges, Bellman-Ford works for such graphs. Bellman-Ford is also simpler than Dijkstra and 
suites well for distributed systems. Bellman ford follows similar steps like Dijkstra’s algorithm, the main difference being all edges would be processed 
through relaxation for |V| - 1 times, instead of just once. 

Steps :
1. We initializes distances from the source to all vertices as infinite and distance to the source itself as 0. We create an array dist[] of size |V| with all 
values as infinite except dist[src] where src is source vertex.
2. For calculating shortest distances, we do the following |V|-1 times where |V| is the number of vertices in given
graph :
a) If dist[v] > dist[u] + weight of edge uv, then we update dist[v] = dist[u] + weight of edge uv
3. Next we also check for negative weight cycles in the graph. step 2 guarantees the shortest distances if the graph doesn’t contain a negative weight cycle. 
If we iterate through all edges one more time and get a shorter path for any vertex, then there is a negative weight cycle. So we check if 
dist[v] > dist[u] + weight of edge uv, then Graph contains negative weight cycle and we print -1. 

This algorithm calculates shortest paths in a bottom-up manner. It first calculates the shortest distances which have at-most one edge in the path. Then, 
it calculates the shortest paths with at-most 2 edges, and so on. After the i-th iteration of the outer loop, the shortest paths with at most i edges are 
calculated. There can be maximum |V| – 1 edges in any simple path, that is why the outer loop runs |v| – 1 times. The idea is, assuming that there is no 
negative weight cycle, if we have calculated shortest paths with at most i edges, then an iteration over all edges guarantees to give shortest path with 
at-most (i+1) edge

*/

class Graph {
    // A class to represent a weighted edge in graph
    class Edge {
        int src, dest, weight;
        Edge()
        {
            src = dest = weight = 0;
        }
    };
 
    int V, E;
    Edge edge[];
 
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i){
            edge[i] = new Edge();
        }
    }
 
    // The main function that finds shortest distances from src
    // to all other vertices using Bellman-Ford algorithm. The
    // function also detects negative weight cycle
    void BellmanFord(Graph graph, int src)
    {
        int V = graph.V, E = graph.E;
        int dist[] = new int[V];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                }
            }
        }
 
        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println(-1);
                return;
            }
        }
        printArr(dist, V);
    }
 
    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }
 
    // Driver method to test above function
    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph
 
        Graph graph = new Graph(V, E);
 
        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
 
        graph.BellmanFord(graph, 0);
    }
}

/*
Output :
Vertex Distance from Source
0   0
1   -1
2   2
3   -2
4   1

Time Complexity : O(VE) where V is the vertices of the graph and E are the edges of the graph
Space Complexity : O(V) as we are creating a dist array with size of V where V is number of vertices. 

Video Link : https://drive.google.com/file/d/1Cvbh4NTYp9SYeh9OXfhvu8e-ngaymsGJ/view?usp=sharing

*/
