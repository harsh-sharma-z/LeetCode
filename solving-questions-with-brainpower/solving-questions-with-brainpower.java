class Solution {
    private int n;
    public long mostPoints(int[][] q) {
        n=q.length;
        // long dp[]=new long[n+1];
        // return solve(0,q,dp);
        long dp[]=new long[200001];
        //dp[i]=max points gained by question from i to n-1
        for(int i=n-1;i>=0;i--)
            dp[i]=Math.max((q[i][0]+dp[i+q[i][1]+1]),dp[i+1]);
        return dp[0];
    }
    // private long solve(int i,int[][] q, long dp[])
    // {
    //     if(i>=n)
    //     return 0;
    //     if(dp[i]!=0)
    //     return dp[i];
    //     long taken=q[i][0]+solve(i+q[i][1]+1,q,dp);
    //     long nottaken=solve(i+1,q,dp);
    //     return dp[i]=Math.max(taken,nottaken);
    // }
}