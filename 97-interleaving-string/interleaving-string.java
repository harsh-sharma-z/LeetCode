class Solution {
    private int m , n , N;
    private Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        m = s1.length();
        n = s2.length();
        N = s3.length();
        dp = new Boolean[m + 1][n + 1];
        return solve(0 , 0 , s1 , s2 , s3);
    }
    private boolean solve(int i , int j , String s1 , String s2 , String s3){
        if(i == m && j == n && i + j == N)
            return dp[i][j] = true;
        if(i + j >= N) // other string didn't get consumed at all
            return dp[i][j] = false;
        if(dp[i][j] != null)
            return dp[i][j];
        boolean res = false;
        if(i < m && s1.charAt(i) == s3.charAt(i + j))
            res = solve(i + 1 , j , s1  , s2 , s3);
        if(res)
            return dp[i][j] = res;
        if(j < n && s2.charAt(j) == s3.charAt(i + j))
            res = solve(i , j + 1 , s1 , s2 , s3);
        return dp[i][j] = res;
    }
}