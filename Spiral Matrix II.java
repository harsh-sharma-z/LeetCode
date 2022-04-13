class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n]; 
        
        int ele = 1; // the element to store in the matrix
        
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; //direction in which we traverse the matrix
        
        int flag = 0; // will take the values 0,1,2,3 to change direction according to increment values in dir array
        
        int row = 0, col = 0; //current row and column
        
        int rowinc = dir[flag % 4][0], colinc = dir[flag % 4][1]; //row increment, column increment
        
        while(ele <= Math.pow(n,2)){
            matrix[row][col] = ele;
            
            if(row + rowinc >= n || row + rowinc < 0 || col + colinc >= n || col + colinc < 0 || matrix[row + rowinc][col + colinc] != 0){
                //change direction
                
                flag++;
                rowinc = dir[flag % 4][0];
                colinc = dir[flag % 4][1];
            }
            
            ele++;
            row += rowinc;
            col += colinc;
        }
        
        return matrix;
        
    }
}
