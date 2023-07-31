class Solution {
    int m , n;
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i[] : dp)
            Arrays.fill(i , -1);
        return solve(0 , 0 , s1 , s2 , dp);
    }
    private int solve(int i , int j , String s1 , String s2 , int[][] dp){
        if(i >= m && j >= n)    
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(i >= m){
            return dp[i][j] = (int)s2.charAt(j) + solve(i , j + 1 , s1 , s2 , dp);
        }

        if(j >= n){
            return dp[i][j] = (int)s1.charAt(i) + solve(i + 1 , j , s1 , s2 , dp);
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i + 1 , j + 1 , s1 , s2 , dp);
        }

        int del_s1 = (int)s1.charAt(i) + solve(i + 1 , j , s1 , s2 , dp);
        int del_s2 = (int)s2.charAt(j) + solve(i , j + 1 , s1 , s2 , dp);

        return dp[i][j] = Math.min(del_s1 , del_s2);
    }
}