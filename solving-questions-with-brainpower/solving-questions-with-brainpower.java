class Solution {
    private int n;
    public long mostPoints(int[][] q) {
        n=q.length;
        long dp[]=new long[n+1];
        return solve(0,q,dp);
    }
    private long solve(int i,int[][] q, long dp[])
    {
        if(i>=n)
        return 0;
        if(dp[i]!=0)
        return dp[i];
        long taken=q[i][0]+solve(i+q[i][1]+1,q,dp);
        long nottaken=solve(i+1,q,dp);
        return dp[i]=Math.max(taken,nottaken);
    }
}