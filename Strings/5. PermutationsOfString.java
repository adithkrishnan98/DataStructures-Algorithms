/*
Question :
Given a string S. The task is to print all permutations of a given string. Implement perm(s) method where s is a string in capital letter. Print all permutations 
of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ size of string ≤ 5

Explanation :
We can solve this problem using backtracking approach. 

Steps :
a) We fix a character in the first position and swap the rest of the character with the first character. Like in ABC, in the first iteration three string are 
formed : ABC, BAC, CBA by swapping A with A, B and C respectively. 
b) We repeat step 1 for rest of the characters like fixing second character B and so on. 
c) Now we swap again to go back to the previous position. Eg : from ABC, we formed ABC by fixing B again, and we backtrack to the previous position and swap B 
with C. So now we got ABC and ACB. 
d) Thus, we repeat the above for BAC and CBA to get all permutations. 

*/

public class PermutationsOfString {
    static void permute(String str, int l, int r)
    {
        if (l == r){
            System.out.print(str + " ");
        }
        else{
            for (int i = l; i <= r; i++){
                //Swapping the string by fixing a character  
                str = swap(str,l,i);
                //Recursively calling function permute() for rest of the characters 
                permute(str, l+1, r);
                //Backtracking and swapping the characters again. 
                str = swap(str,l,i);
            }
        }
    }
    
    // function to convert string to characters and then swap them and re convert to string
    static String swap(String a, int i, int j){
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args){
        String str1 = "ABC";
        int n1 = str1.length();
        permute(str1, 0, n1-1);

        System.out.println();
        
        String str2 = "ABSG";
        int n2 = str2.length();
        permute(str2, 0, n2-1);
    }
}

/*
Output :
ABC ACB BAC BCA CBA CAB

ABSG ABGS ASBG ASGB AGSB AGBS BASG BAGS BSAG BSGA BGSA BGAS SBAG SBGA SABG SAGB SGAB SGBA GBSA GBAS GSBA GSAB GASB GABS

Time Complexity : O(n * n!) as it there are n! permutations which it takes O(n) time to print each permutation
Space Complexity : O(n) as we create a char array with length of characters of string

Video Explanation : https://drive.google.com/file/d/1mVT2FLbTcflmcYe1aoVFHLf1EBqWMZwT/view?usp=sharing

*/
