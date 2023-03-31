class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][] presum = new int[m+1][n+1];
        int[][][] dp = new int[m][n][k];
        for(int[][] a: dp){
            for(int[] b: a) Arrays.fill(b, -1);
        }
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                presum[i][j] = presum[i+1][j] + presum[i][j+1] - presum[i+1][j+1] + (pizza[i].charAt(j)=='A' ? 1 : 0);
            }
        }
        return find(0, 0, m, n, k-1, presum, dp);
    }

    private int find(int r, int c, int m, int n, int k, int[][] presum, int[][][] dp){
        if(presum[r][c]==0) return 0;
        if(k==0)    return 1;
        if(dp[r][c][k]!=-1) return dp[r][c][k];
        int ans = 0;
        for(int i=r+1; i<m; i++){
            if(presum[r][c]-presum[i][c]>0){
                ans = (ans + find(i, c, m, n, k-1, presum, dp))%1000000007;
            }
        }
        for(int j=c+1; j<n; j++){
            if(presum[r][c]-presum[r][j]>0){
                ans = (ans + find(r, j, m, n, k-1, presum, dp))%1000000007;
            }
        }
        return dp[r][c][k] = ans;
    }
}