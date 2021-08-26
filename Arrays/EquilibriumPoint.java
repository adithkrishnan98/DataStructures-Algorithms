
public class EquilibriumPoint {

    int findEquilibrium(int [] A, int n){
        int sum = 0; // initialize sum of whole array
        int leftsum = 0; // initialize leftsum
 
        /* Find sum of the whole array */
        for (int i = 0; i < n; ++i){
            sum += A[i];
        }
 
        for (int i = 0; i < n; ++i) {
            sum -= A[i]; // sum is now right sum for index i
            if (leftsum == sum){
                return i;
            }
            leftsum += A[i];
        }
 
        /* If no equilibrium index found, then return 0 */
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumPoint ep = new EquilibriumPoint();
        int [] ar = {1};
        int n = ar.length;
        int [] ar2 = {1,3,5,2,2};
        int n2 = ar2.length;
        int result1 = ep.findEquilibrium(ar, n);
        int result2 = ep.findEquilibrium(ar2, n2);
        System.out.println(result1);
        System.out.println(result2);
    }
}

/* Output :
0
2

Time Complexity : O(n) as we first find find the sum of whole array (for n elements) which takes O(n) time and then we loop through n elements again 
and find left sum which takes O(n) again. So total time complexity is O(n) + O(n) = O(2n) = O(n)
Space Complexity : O(1) as we do not utilize any extra space

Video Explanation : https://drive.google.com/file/d/1h_sU8QWz6-Os5UKSvhdyF6sUCasoobPf/view?usp=sharing */
