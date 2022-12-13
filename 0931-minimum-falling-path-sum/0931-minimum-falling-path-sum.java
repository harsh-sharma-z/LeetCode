class Solution {
   int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        dp = new int[n][m];
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, min(n-1,i,matrix));
        }
        
        return min;
    }
    
    public int min(int i, int j, int[][] matrix){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length)
            return 100000;
        if(i==0)
            return matrix[0][j];
        if(dp[i][j]!=0)
            return dp[i][j];
        
        int left = matrix[i][j] + min(i-1, j-1, matrix);
        int down = matrix[i][j] + min(i-1, j, matrix);
        int right = matrix[i][j] + min(i-1, j+1, matrix);
        
        return dp[i][j] = Math.min(left, Math.min(down, right));
        
    }
}