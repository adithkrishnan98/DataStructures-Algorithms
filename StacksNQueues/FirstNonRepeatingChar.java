package Problems.StacksNQueues;

/* FIRST NON-REPEATING CHARACTER IN A STREAM
Given an input stream of N characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is inserted to the stream.
If no non repeating element is found print -1.
Argument is x character array which are inserted to the stream.
Output:
For each test case in a new line print the first non repeating elements separated by spaces present in the stream at every instinct when a character is added to the stream, if no such element is present print -1.
Constraints:
1 <= N <= 500 */

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
