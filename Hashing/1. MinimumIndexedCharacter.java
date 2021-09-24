/*
Question :
Given a string and another string p, find the character in p that is present at the minimum index in str. If no character of p is present in str then print -1.

Constraints :
1 <= |str|, |p| <= 105

Explanation :
In the brute force approach, we use 2 loops to find the first index of each character of p in string. We compare it and then we print the character having the
minimum index. If not such character of p is found in string then we print -1. But this method takes O(mn) time complexity where m = length of p and n is length 
of string. So a better approach is to use hashing. 

We create a hash table with key and value where the key is the character and value is the index. We store first index of each character of str in the hash table 
and then for each character of p we check if it is present in the hash table or not. If it is present then we get its index from hash table and update the 
minimum index (default set to Integer.MAX_VALUE). For no matching character, we print -1. This approach takes O(m+n) time complexity and O(n) space complexity 
where n is size of hash table. 

*/

import java.util.HashMap;

public class MinimumIndexedCharacter {
    static void printMinIndexChar(String str, String patt){
        // map to store the first index of each character of 'str'
        HashMap<Character, Integer> hm = new HashMap<>();
         
        // to store the index of character having minimum index
        int minIndex = Integer.MAX_VALUE;
      
        // lengths of the two strings
        int m = str.length();
        int n = patt.length();
      
        // store the first index of each character of 'str'
        for (int i = 0; i < m; i++){
            if(!hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i),i);
            }
        }
      
        // traverse the string 'patt'
        for (int i = 0; i < n; i++){
            // if patt[i] is found in 'um', check if it has the minimum index or not accordingly update 'minIndex'
            if (hm.containsKey(patt.charAt(i)) && hm.get(patt.charAt(i)) < minIndex){
                minIndex = hm.get(patt.charAt(i));
            }
      
        }
        // print the minimum index character
        if (minIndex != Integer.MAX_VALUE){
            System.out.println(str.charAt(minIndex));
        }
      
        // if no character of 'patt' is present in 'str'
        else{
            System.out.println(-1);
        }
    }
     
    public static void main(String[] args)
    {
        String str1 = "skilllync";
        String p1 = "gyt";
        printMinIndexChar(str1, p1);
        String str2 = "Unclejohn";
        String p2 = "sis";
        printMinIndexChar(str2, p2);
    }
}

/*

Output :
y
-1

Time Complexity : O(m+n) where m is length of p and n is length of str
Space Complexity : O(n) where n is number of elements in hash table

Video Link : https://drive.google.com/file/d/1Kz1CYR_h0PM8plQQUUjAJHIcwUCqSCY-/view?usp=sharing

*/
