/* 
Question :
Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream.
If no non repeating element is found print -1.
Argument is x character array which are inserted to the stream.
Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.
Constraints:
1 <= N <= 500 

Explanation : 

Steps - 
a) Create a count array of size 26(assuming only lower case characters are present) and initialize it with zero.
b) Create a queue of char datatype.
c) Store each character in queue and increase its frequency in the hash array.
d) For every character of stream, we check front of the queue.
e) If the frequency of character at the front of queue is one, then that will be the first non-repeating character.
f) Else if frequency is more than 1, then we pop that element.
g) If queue became empty that means there are no non-repeating characters so we will print -1.

*/


import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {
    final static int MAX_CHAR = 26;
    
    static void firstNonRepeatingChar(String str){
        // create count array of size 26 (assuming only lower case characters are present)
        int[] charCount = new int[MAX_CHAR];
 
        // Queue to store Characters
        Queue<Character> q = new LinkedList<Character>();
 
        // traverse whole stream
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
 
            // push each character in queue
            if(charCount[ch - 'a'] == 0 ){
                q.add(ch);
            }
 
            // increment the frequency count
            charCount[ch - 'a']++;
 
            // check for the non repeating character
            while (!q.isEmpty()) {
                if (charCount[q.peek() - 'a'] > 1)
                    q.remove();
                else {
                    System.out.print(q.peek() + " ");
                    break;
                }
            }
            if (q.isEmpty()){
                System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str = "aabc";
        firstNonRepeatingChar(str);
        String str1 = "aac";
        firstNonRepeatingChar(str1);
    }
}

/*
Output :
a -1 b b 
a -1 c

Time Complexity : O(n) where n is the number of characters we need to go through of the given string
Space Complexity : O(n) as we are creating a queue and also a charCount array to store counts of elements. 

Video Explanation : https://drive.google.com/file/d/1uxBddqZakK4fKZ7pGyV-s7F6eenpDe4X/view?usp=sharing

*/
