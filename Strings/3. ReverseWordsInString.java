/*
Question : 
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots. Complete the function which takes a string S containing characters and outputs a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Explanation : 
In this problem we can use the string method "split" and regex (regular expressions) to easily split the string at the dot (.) and store indivual words in an 
array. Then we loop through the array in reverse to print the words in reverse order. The time complexity would be O(n) where n is the number of words in the array.

*/

public class ReverseWordsInString {
    
    void reverseWords(String str){
        String [] words = str.split("\\.");
        for(int i = words.length-1; i>=0; i--){
            System.out.print(words[i]+".");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseWordsInString rs = new ReverseWordsInString();
        String str = "i.like.this.program.very.much";
        String str2 = "pqr.mno";
        rs.reverseWords(str);
        rs.reverseWords(str2);
    }
}

/*
Output :
much.very.program.this.like.i
mno.pqr
 
Time Complexity : O(n) as we have used a single for loop to loop through n number of words in an array
Space Complexity : O(n) as we create a new words array to store the split words

Video Explanation : https://drive.google.com/file/d/1jmC9LppPkr8Je9ah2lRQ5QWyT428pnqS/view?usp=sharing

*/
