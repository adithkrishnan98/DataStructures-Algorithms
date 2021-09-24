/*
Question :
Given a string S. The task is to find the first repeated character in it. We need to find the character that occurs more than once and whose index of second 
occurrence is smallest. S contains only lowercase letters. Argument is a string S. Print the first repeating character in the string. If no such character exist 
print -1.

Constraints:
1 <= |S| <= 10^4

Explanation :
In the brute force approach, we can run two nested loops. We start traversing from left side and for every character, we check if it repeats or not. If the 
character repeats, increment count of repeating characters. When the count becomes greater than 1, return the character. Time Complexity of this solution is 
O(n2) which is not going to be efficient. 

Another approach is to use Sorting to solve the problem in O(nLog n) time. First we convert the string into array of its characters. Next, we first copy the 
given array to an auxiliary array temp[]. We sort the temp array using a O(nLogn) time complexity sorting algorithm. Lastly, we loop through the input array 
from left to right. For every element, count its occurrences in temp[] using binary search. As soon as we find a character that occurs more than once, we return 
the character. This step can be done in O(NLog N) time.

A better approach than both the above solutions would be to use hashing technique. We create a empty hash table. Next, we loop through the string and for every 
character we store its index and its count as key and value respectively. Then we loop through the table again and check if any of the values are greater than 1, 
then we return it and break out of the loop. If no value if found and the loop has reached the end, we print -1. 

*/

import java.util.HashMap;

public class FindFirstRepeatedChar {
    
    void findFirstRepeatedChar(String s){
        if(s.length() <= 0){
            System.out.println("No string found");
        }
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        for(int i = 0; i<s.length(); i++){
            int counter = 0;
            if(hM.containsKey(s.indexOf(s.charAt(i)))){
                counter = hM.get(s.indexOf(s.charAt(i)));
            }
            hM.put(s.indexOf(s.charAt(i)), counter+1);
        }
        for(int i = 0; i<s.length();){
            if(hM.get(s.indexOf(s.charAt(i))) > 1){
                System.out.println(s.charAt(i));
                break;
            }
            else if(hM.get(s.indexOf(s.charAt(i))) == 1){
                i++;
                if(i == s.length()){
                    System.out.println(-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindFirstRepeatedChar str = new FindFirstRepeatedChar();
        String s1 = "skilllync";
        str.findFirstRepeatedChar(s1);
        String s2 = "helloworld";
        str.findFirstRepeatedChar(s2);
    }
}

/*

Output :
l
l

Time Complexity : O(n) as we loop through n characters of the string s
Space Complexity : O(n) as we create a hash map for n characters in the string. 

Video Link : https://drive.google.com/file/d/1VaI5sgrGgunAeIVy7a3bkYVAMUAGSacb/view?usp=sharing

*/
