/*
Question :
Given two strings: string X of length m and string Y of length n find the longest common subsequence. The longest sequence of characters that appear left-to-right 
(but not necessarily in a contiguous block) in both strings. For example, if X = “ABCBDAB” and Y = “BDCABA”, the LCS(X, Y) = {“BCBA”, “BDAB”, “BCAB”}.

Explanation : 
In the brute force approach, we can check if every subsequence of X[1..m] to see if it is also a subsequence of Y[1...n]. As there are 2^m subsequences possible 
of X, the time complexity for this approach would be O(n.2^m) where m is length of first string and n is length of second string. This is not a very efficient 
approach. 

The LCS problem satisfies both optimal substructure property (problem can be broken down into smaller sub problems) and also overlapping subproblems property 
(recalculation of same result is done multiple times). Therefore, this problem can be solved using dynamic programming either in the top down (memoized) or bottom 
up (tabulation) approach. The base case is that if m (length of first string) is 0 or n (length of second string) is 0 then we return 0. Else, we check if the 
characters match, if they do we perform LCS by moving one character left for both the strings. Else if there is not match, we find the max of either moving a 
character to the left in string 1 and keeping string 2 as same or we move a character to the left in string 2 and keeping string 1 as same. We keep doing this 
over till m or n = 0 and store the results in a lookup table. 

*/

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubSeq {
    public static int findLCS(String X, String Y, int m, int n, Map<String, Integer> lookup)
    {
        // return if the end of either string is reached
        if (m == 0 || n == 0) {
            return 0;
        }
 
        // construct a unique map key from dynamic elements of the input
        String key = m + "|" + n;
 
        // if the subproblem is seen for the first time, solve it and store its result in a map
        if (!lookup.containsKey(key))
        {
            // if the last character of `X` and `Y` matches
            if (X.charAt(m - 1) == Y.charAt(n - 1)) { 
                lookup.put(key, findLCS(X, Y, m - 1, n - 1, lookup) + 1);
            }
            else {
                // otherwise, if the last character of `X` and `Y` don't match
                lookup.put(key, Integer.max(findLCS(X, Y, m, n-1, lookup), findLCS(X, Y, m - 1, n, lookup)));
            }
        }
 
        // return the subproblem solution from the map
        return lookup.get(key);
    }
 
    public static void main(String[] args)
    {
        String X = "ABCBDAB", Y = "BDCABA";
 
        // create a map to store solutions to subproblems
        Map<String, Integer> lookup = new HashMap<>();
 
        System.out.println("The length of the LCS is " + findLCS(X, Y, X.length(), Y.length(), lookup));
    }
}

/*

Output :
The length of LCS is 4

Time Complexity : O(m x n) where m and n are the lengths of 2 strings
Space Complexity : O(m x n) where m and n are lengths of two strings. Extra space is taken as a result of creation of hashmap used to store previously calculated values

Video Link : https://drive.google.com/file/d/1zDyhSCu3cpg4sU1X7U9uaa7a_EwNei4c/view?usp=sharing

*/
