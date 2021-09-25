/*
Question :
Given an array of strings A[], determine if the strings can be chained together to form a circle. A string X can be chained together with another string Y if the 
last character of X is same as first character of Y. If every string of the array can be chained, it will form a circle. For eg for the array arr[] = {“great", 
“skill", “trains", “lync"} the answer will be Yes as the given strings can be chained as “great", “trains", “skill" and “lync"

Input: array A[].

Output: If chain can be formed, then print 1, else print 0.

Constraints
0 <= size of A <= 30
0 <= A[i] <= 10

Explanation :
We solve this problem by treating this as a graph problem, where vertices will be the first and last character of strings, and we will draw an edge between two 
vertices if they are the first and last character of the same string, so a number of edges in the graph will be same as the number of strings in the array. If a 
loop among graph vertices is possible then, we can reorder the strings such that circle is possible otherwise we cannot. Now to check whether a graph can have a 
loop which goes through all the vertices, we’ll check two conditions :

a) Indegree and Outdegree of each vertex should be the same.
b) The graph should be strongly connected.

The first condition can be checked easily by keeping two arrays, in and out for each character. For checking whether a graph is having a loop which goes through 
all vertices is the same as checking complete directed graph is strongly connected or not because if it has a loop which goes through all vertices then we can 
reach to any vertex from any other vertex that is, the graph will be strongly connected and the same argument can be given for reverse statement also. 

Now for checking the second condition we will just run a DFS from any character and visit all reachable vertices from this, now if the graph has a loop then after 
one DFS all vertices should be visited, if all vertices are visited then we will return true otherwise false so visiting all vertices in a single DFS flags a 
possible ordering among strings. 

*/

import java.util.ArrayList;

public class CircleOfStrings {
    public static boolean possibleOrderAmongString(String s[], int n)
{
    int m = 26;
    boolean mark[] = new boolean[m];
    int in[] = new int[26];
    int out[] = new int[26];
     
    ArrayList adj = new ArrayList();
    for(int i = 0; i < m; i++)
        adj.add(new ArrayList<>());
         
    // Process all strings one by one
    for(int i = 0; i < n; i++)
    {
         
        // Find first and last characters
        int f = (int)(s[i].charAt(0) - 'a');
        int l = (int)(s[i].charAt(s[i].length() - 1) - 'a');
         
        // Mark the characters
        mark[f] = mark[l] = true;
         
        // Increase indegree and outdegree count
        in[l]++;
        out[f]++;
         
        // Add an edge in graph
        adj.get(f).add(l);
    }
     
    // If for any character indegree is not equal to outdegree then ordering is not possible
    for(int i = 0; i < m; i++)
    {
        if (in[i] != out[i]){
            return false;
        }
    }
    return isConnected(adj, mark, s[0].charAt(0) - 'a');
}
 
// Returns true if all vertices are strongly connected i.e. can be made as loop
public static boolean isConnected(ArrayList adj, boolean mark[], int src)
{
    boolean visited[] = new boolean[26];
     
    // Perform a dfs from src
    dfs(adj, visited, src);
    for(int i = 0; i < 26; i++)
    {
     
        /* ith character is marked (i.e. it was first or
         last character of some string) then it should
         be visited in last dfs (as for looping, graph
         should be strongly connected) */
        if (mark[i] && !visited[i]){
            return false;
        }
    }
     
    // If we reach that means graph is connected
    return true;
}
 
// Utility method for a depth first
// search among vertices
public static void dfs(ArrayList adj, boolean visited[], int src)
{
    visited[src] = true;
    for(int i = 0; i < adj.get(src).size(); i++){
        if (!visited[adj.get(src).get(i)]){
            dfs(adj, visited, adj.get(src).get(i));
        }
    }
}

public static void main(String[] args)
{
    String s[] = { "ab", "bc", "cd", "da" };
    int n = s.length;
    System.out.println(possibleOrderAmongString(s, n) ? 1 : 0);

    String s1[] = { "abc", "bcd", "cdf" };
    int n1 = s1.length;
    System.out.println(possibleOrderAmongString(s1, n1) ? 1 : 0);
    }
}

/*

Output :
1
0

Time Complexity : 
Space Complexity : O(1) as we create the arrays mark, in, out and visited all containing constant space of 26 elements

Video Link : https://drive.google.com/file/d/1aU_rrHvA603AJ65l5P70fv90_gkGrPS8/view?usp=sharing

*/
