class Solution {
    public void rotate(int[][] matrix) {
        
        
       int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=1;i<m;i++){
            for(int j=0;j<i;j++){
                
                matrix[i][j]=matrix[i][j]-matrix[j][i];
                matrix[j][i]=matrix[i][j]+matrix[j][i];
                matrix[i][j]= matrix[j][i]-matrix[i][j];
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                
                matrix[i][j]=matrix[i][j]-matrix[i][n-j-1];
                matrix[i][n-j-1]=matrix[i][j]+matrix[i][n-j-1];
                matrix[i][j]= matrix[i][n-j-1]-matrix[i][j];
            }
                    
        
    }
    }
}