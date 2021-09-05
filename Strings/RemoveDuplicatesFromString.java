package Problems.Strings;

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
