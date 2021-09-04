/*
Question : 
Your task is to implement the function strstr. The function takes two strings as arguments (s,x) and locates the occurrence of the string x in the string s. The 
function returns an integer denoting the first occurrence of the string x in s (0 based indexing) if it is present else return -1.

Expected Time Complexity: O(|s|*|x|)
Expected Space Complexity : O(1)

Constraints:
1 <= |s|,|x| <= 1000

Explanation : 
In this problem, the brute force approach would be the to run a loop from start to end and for every index in the given string check whether the sub-string can be 
formed from that index. Eg : Let's say there is a string of length N and a substring of length M. A nested loop is run, where the outer loop runs from 0 to (N-M) 
and the inner loop from 0 to M. For every index we check if the sub-string traversed by the inner loop is the given sub-string or not. This takes O(MxN) time 
complexity due to the nested loop. A more efficient way of solving this problem would be as below :

We can think about the solution logically. First we initilalise a count variable and loop variable i as 0. We take the 2nd string and find it's length. We loop 
through the first string and for each character we check if character[str1] == character[str2]. If it is equal then we increment the count variable by 1. If the 
count value == length of string2 then we have a substring match and we break the loop else we don't have a match. 

So first we traverse through the first string and maintain a count pointer for string 2 from 0th index. For each iteration we compare the current character in 
s1 and check it with the pointer at s2. If they are equal we incremenet count by 1 and if they are not we set count back to 0. We also check when the count value 
is equal to the length of string s2, if true we break and return the value which would be pointer of string s1 – count. There is also an edge case of string 
consisting of duplicate characters that's been handled. 

Below is the implementation : 

*/

public class FindSubStrIndex {
    public static int Substr(String s1, String s2){
        int counter = 0; //pointer of s2
        int i = 0;
        for(;i<s1.length();i++){
            if(s2.length() > s1.length()){
                return -1;
            }
            if(counter==s2.length()){
                break;
            }
            if(s2.charAt(counter)==s1.charAt(i)){
                counter++;
            }else{
                //Special case where characters preceding the i'th character is duplicate
                if(counter>0){
                    i -= counter;
                }
                counter = 0;
            }
        }
        return counter < s2.length()?-1:i-counter;
    }
    public static void main (String[] args) {
        String s1 = "Skilllync";
        String s1a = "mississippi";
        String s1b = "skil";
        
        System.out.println(Substr(s1, "Skill")); 
        System.out.println(Substr(s1a, "issip")); 
        System.out.println(Substr(s1b, "skilllync")); 
    }
}

/*
Output :
0
4
-1

The updated time complexity for this solution would be O(N) since we only traverse the entire string once through the length of its characters, which is more 
efficient than the expected O(|s|*|x|) complexity. 
The space complexity remains O(1).

Video Explanation : https://drive.google.com/file/d/1k4cgAX1pM3YL9k7bsD_7t33_zhAfgJNb/view?usp=sharing

*/

