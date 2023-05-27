class Solution {
    private int n;
    public String stoneGameIII(int[] stones) {
        n=stones.length;
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // int diff=solve(stones,0,dp); //alice-bob;
        for(int i=n-1;i>=0;i--)
        {
            dp[i]=stones[i]-dp[i+1];
            if(i+2<=n)
            dp[i]=Math.max(dp[i],stones[i]+stones[i+1]-dp[i+2]);
            if(i+3<=n)
            dp[i]=Math.max(dp[i],stones[i]+stones[i+2]+stones[i+1]-dp[i+3]);
        }
        int diff=dp[0];
        if(diff<0)
        return "Bob";
        else
        if(diff>0)
        return "Alice";
        return "Tie";
    }


    //Bottom-up
    // private int solve(int[] stones, int i,int[] dp)
    // {
    //     if(i>=n)
    //     return 0;
    //     if(dp[i]!=-1)
    //     return dp[i];
    //     int res=stones[i]-solve(stones,i+1,dp);
    //     if(i+1<n)
    //     res=Math.max(res,(stones[i]+stones[i+1]-solve(stones,i+2,dp)));
    //     if(i+2<n)
    //     res=Math.max(res,(stones[i]+stones[i+1]+stones[i+2]-solve(stones,i+3,dp)));
    //     return dp[i]=res;
    // }
}