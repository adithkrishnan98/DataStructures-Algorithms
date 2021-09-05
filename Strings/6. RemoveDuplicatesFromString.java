/*
Question :
Given a string, the task is to remove duplicates from it. Expected time complexity O(n) where n is length of input string and extra space O(1) under the 
assumption that there are total 256 possible characters in a string. Original order of characters must be kept same. Complete the function that takes a string 
and prints the modified string without duplicates and same order of characters.

Constraints:
1 <= |string|<= 1000

Explanation : 
The idea is to keep track of visited characters from given input string through an integer array of size 256 (All possible characters).

Steps: 
Create an integer array of size 256 in order to keep track of all possible characters.
Iterate over the input string, and for each character :
Lookup into the array with the ASCII value of character as index: 
If value at index is 0, then copy the character into original input array and increase the endIndex also update the value at index as -1.
Else skip the character.

*/

import java.util.Arrays;

public class RemoveDuplicatesFromString {
    static char[] removeDuplicatesFromString(String string)
    {
        //table to keep track of visited characters
        int[] table = new int[256];
        char[] chars = string.toCharArray();

        //to keep track of end index of resultant string
        int endIndex = 0;
        
        for(int i = 0; i < chars.length; i++)
        {
            if(table[chars[i]] == 0)
            {
                table[chars[i]] = -1;
                chars[endIndex++] = chars[i];
            }
        }
        
        return Arrays.copyOfRange(chars, 0, endIndex);
    }

    // Driver code
    public static void main(String[] args)
    {
        String str1 = "skilllync";
        String str2 = "skill lync courses";
        System.out.println(removeDuplicatesFromString(str1));
        System.out.println(removeDuplicatesFromString(str2));
    }
}

/*
Output :
skilync
skil yncoure

Time Complexity : O(n) as we are looping through n elements of the string
Space Complexity : O(1). Even though we are creating an array of 256 characters and using extra space, for any amount input we get the extra space is going to be 
constant and so it's going to be O(1)

Video Explanation : https://drive.google.com/file/d/1Snd5yPJtHWrJcB17f3KwfM5_RLD9bJTG/view?usp=sharing

*/
