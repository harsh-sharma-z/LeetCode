class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) 
            Arrays.fill(dp[i] , -1);
        return solve(0 , n-1 , dp , s);
        
    }

    private int solve(int i,int j,int[][] dp,String s){
     if(i == j) 
        return 1;
     if(dp[i][j] != -1) 
        return dp[i][j];
     int ans = Integer.MAX_VALUE;
     for(int k = i ; k < j ; k++){
        ans = Math.min(ans , solve(i,k,dp,s) + solve(k+1,j,dp,s));
    }
     return dp[i][j] = s.charAt(i) == s.charAt(j)?ans-1:ans;
    }
}