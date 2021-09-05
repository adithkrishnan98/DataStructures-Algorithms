package Problems.Strings;

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
