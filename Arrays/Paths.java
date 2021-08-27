package Problems;
public class Paths {
    static int numPaths(int row, int col){
        if(row <= 0 || col <= 0){
            return -1;
        }
        else if(row >= 10 || col >= 10){
            return -1;
        }
        else if(row == 1 || col == 1){
            return 1;
        }
        return numPaths(row-1, col) + numPaths(row, col-1);

    }
        
    public static void main(String[] args) {
        System.out.println(numPaths(3,3));
    }
}


// (0,0) --> (0,1) --> (0,2) --> (1,2) --> (2,2)
// (0,0) --> (1,0) --> (2,0) --> (2,1) --> (2,2)
// (0,0) --> (0,1) --> (1,1) --> (2,1) --> (2,2)
// (0,0) --> (0,1) --> (1,1) --> (1,2) --> (2,2)
// (0,0) --> (1,0) --> (1,1) --> (1,2) --> (2,2)
// (0,0) --> (1,0) --> (1,1) --> (2,1) --> (2,2)

