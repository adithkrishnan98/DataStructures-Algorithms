package Problems.Arrays;

// O(N^2) TIME COMPLEXITY SOLUTION
// class LeadersInArray{
   
//     void printLeaders(int arr[]){
//         for(int i = 0; i < arr.length; i++){
//             int j;
//             for(j = i + 1; j < arr.length; j++){
//                 if (arr[i] <=arr[j]){
//                     break;
//                 }
//             }
//             if (j == arr.length){ // loop did not break
//                 System.out.print(arr[i] + " ");
//             } 
//         }
//     }

//     public static void main(String[] args){
//         LeadersInArray lead = new LeadersInArray();
//         int arr[] = new int[]{1, 2, 3, 4, 0};
//         lead.printLeaders(arr);
//     }
// }


// O(N) TIME COMPLEXITY SOLUTION
class LeadersInArray {

    void printLeaders(int [] arr){
        int max_from_right = arr[arr.length - 1];
        System.out.print(max_from_right + " ");

        for(int i = arr.length-2; i>=0; i--){
            if(max_from_right < arr[i]){
                max_from_right = arr[i];
                System.out.print(max_from_right + " ");
            }
        }
    }

    public static void main(String[] args) {
        LeadersInArray lead = new LeadersInArray();
        int arr[] = {16, 17, 4, 3, 5, 2};
        lead.printLeaders(arr);
    }
}
