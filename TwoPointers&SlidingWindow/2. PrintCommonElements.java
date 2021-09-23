/*
Question :
Given 3 increasingly sorted arrays A, B, C of sizes N1, N2 and N3, the task is to print all the common elements in this array. Avoid printing same common element 
more than once. 

Constraints :
1 <= N1, N2, N3 <= 10^7
1 <= Ai, Bi, Ci <= 10^18

Explanation :
In this approach, we run a single loop and traverse the 3 arrays. We have current element traversed in arr1 to be x, arr2 to be y and arr3 to be z. Then if x, y, 
z are same we simply print any of of them as common element and move ahead all three ways. Else if x < y then we can move ahead in ar1 as x cannot be common 
element and if x > z and y > z then we simply move ahead in ar3 as z cannot be a common element. 

*/

public class CommonElements {
    void printCommonElements(int [] arr1, int [] arr2, int [] arr3){
        int i, j, k;
        i = j = k = 0;
        // Iterate through three arrays while all arrays have elements
        while (i < arr1.length && j < arr2.length && k < arr3.length)
        {
            // If x = y and y = z, print any of them and move ahead in all arrrays
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]){   
                System.out.print(arr1[i] + " ");   
                i++; 
                j++; 
                k++; 
            }
 
            // x < y
            else if (arr1[i] < arr2[j]){
                i++;
            }

            // y < z
            else if (arr2[j] < arr3[k]){
                j++;
            }

            // We reach here when x > y and z < y, i.e., z is smallest
            else{
                k++;
            }
        }
    }

    public static void main(String[] arrgs) {
        CommonElements obj = new CommonElements();
        int [] arr1 = {1, 5, 10, 20, 40, 80};
        int [] arr2 = {6, 7, 20, 80, 100};
        int [] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};
        obj.printCommonElements(arr1, arr2, arr3);
    }
}
 
/*

Output :
20 80

Time Complexity : O(n1 + n2 + n3) where n1, n2, n3 are lengths of the arrays arr1, arr2, arr3 respectively. 
Space Complexity : O(1) as no extra space has been utilised

Video Link : https://drive.google.com/file/d/10tTNxuF2qyipM_Ll-eDebQhG1NZHny_o/view?usp=sharing

*/
