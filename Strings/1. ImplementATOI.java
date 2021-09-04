/*
Question : 
Your task is to implement the function ATOI. The function takes a string (str) as argument and converts it to an integer and returns it. Output will be an integer 
denoting the converted integer, if the input string is not a numerical string then output will be -1.

Expected Time Complexity: O(|S|), |S| = length of string S.
Expected Space Complexity : O(1)

Constraints:
1<=length of (s)<=10

Explanation : 
A simple implementation to conver a string to an integer can consist of many steps. First we initialise a variable called result as 0. To consider the sign 
present before a number we also initialise a variable called sign to 1. We also initiate loop variable i as 0. Then we loop through the length of the string 
and update the result for each charecter of the string by using the forumula result = result * 10 + Character.getNumericValue(s.charAt(i)). Finally we return the 
product of sign and result variables which will be an integer. We also check at first for edge cases like if whitespace is present, if the sign is negative or 
positive and if the string is a valid string or not. If it contains charecters other than numbers it will be an invalid string and thus cannot be converted to a 
proper integer. 

So we first check if whitespace is preset, if it is we just increment i. Similarly we check for sign, if - is present we re-assign sign as -1 and if + is present, 
we re-assign sign as 1. Next, we say while i is less than length of string and it is between charecters '0' and '9' we will loop through the string and for each 
i we check if the charecter[i] is a true or not ie if it is a valid charecter or not. if it false we return 1 else we do 
result = result * 10 + Character.getNumericValue(s.charAt(i)). And finally, we return a product of sign with result which will give us our integer number. 

Below is the solution code :

*/

public class ATOI {
    static int myAtoi(String s){
        int result = 0;
        int sign = 1;
        int i = 0;
        while (s.charAt(i) == ' ') //checks whether whitespace is there
        {
            i++;
        }
        if(s.charAt(i) == '-'){ //checks whether sign of number is negative 
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+'){ //checks whether sign of number is positive 
            sign = 1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') { // checks whether character i is between 0 and 9
            for (; i < s.length(); i++){
                if (Character.isDigit(s.charAt(i)) == false) //character is valid or not
                {
                    return -1;
                }
                result = result * 10 + Character.getNumericValue(s.charAt(i)); 
            }
        }
 
        // return result.
        return sign * result;
    }

    public static void main(String[] args) {
        String str1 = "-123";
        String str2 = "  235";
        String str3 = "+12a";

        System.out.println(myAtoi(str1));
        System.out.println(myAtoi(str2));
        System.out.println(myAtoi(str3));
    }
}

/*
Output :
-123
235
-1

The time complexity of the above solution will be O(|S|) where |S| is the length of the string since we need to go through each charecter of the string and then 
perform the result operation on it. 
The space complexity would be O(1) as no extra space is being utilized.

Video Explanation : https://drive.google.com/file/d/1qG63JA6FA4dR30-zYXFbYW16a_kfuub1/view?usp=sharing
