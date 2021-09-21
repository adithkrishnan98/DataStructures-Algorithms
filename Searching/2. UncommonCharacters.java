/*
Question :
Find and print the uncommon characters of the two given strings S1 and S2. The strings contains only lowercase characters and can contain duplicates. Print the 
uncommon characters of the two given strings in sorted order.

Constraints:
1 <= |S1|, |S2| <= 105 > 105

Explanation :
In the brute force approach, we use nested for loops to first check each character of 1st string whether it's present in 2nd string and simiarly check each 
character of 2nd string to see if it is present in first string. Thus the time complexity would be O(n^2) and if we have duplicates in the string we would have 
to handle that case as well. Thus a more efficient solution would be by using hashing. 

We use a hash table of size 26 and initially mark the presence of each character as zero which says that both strings do not contain that character. Next, we 
traverse 1st string and mark presence of each character of 1st string as 1. Next, we traverse the 2nd string and for each character we check it's presence in 
the hash table if it is been marked 1 or -1 (in case of duplicates) and if it has, then we mark it as -1 and for characters that are specific to string 2 we 
mark those as 2. Thus in the end we go through the array and print elements marked 1 and 2 as the uncommon characters from both strings. 

*/

public class PrintUncommonChars {
    static int MAX_CHAR = 26;

    static void findAndPrintUncommonChars(String str1, String str2)
    {
        // mark presence of each character as 0 in the hash table 'present[]'
        int present[] = new int[MAX_CHAR];
        for (int i = 0; i < MAX_CHAR; i++)
        {
            present[i] = 0;
        }
 
        int l1 = str1.length();
        int l2 = str2.length();
 
        // for each character of str1, mark its
        // presence as 1 in 'present[]'
        for (int i = 0; i < l1; i++)
        {
            present[str1.charAt(i) - 'a'] = 1;
          
        }
 
        // for each character of str2
        for (int i = 0; i < l2; i++){
             
            // if a character of str2 is also present in str1, then mark its presence as -1
            if (present[str2.charAt(i) - 'a'] == 1 || present[str2.charAt(i) - 'a'] == -1)
            {
                present[str2.charAt(i) - 'a'] = -1;
            }
             
            // else mark its presence as 2
            else
            {
                present[str2.charAt(i) - 'a'] = 2;
            }
        }
 
        // print all the uncommon characters
        for (int i = 0; i < MAX_CHAR; i++)
        {
            if (present[i] == 1 || present[i] == 2)
            {
                System.out.print((char) (i + 'a') + " ");
            }
        }
    }
 
    public static void main(String[] args)
    {
        String str1 = "characters";
        String str2 = "alphabets";
        findAndPrintUncommonChars(str1, str2);
    }
}

/*

Output :
b c l p r

Time Complexity : O(m + n) where m and n are lengths of string 1 and string 2 respectively
Space Complexity : O(n) as we are creating a hash table to store the presence of characters.

Video Link : https://drive.google.com/file/d/1QlgPrd1PvTC-enotBhUGvzXwyFp1BrbZ/view?usp=sharing

*/
