class Solution {
    int o,z,l,h;
    int mod=1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        l=low;
        h=high;
        z=zero;
        o=one;
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
        return solve(0,dp);
    }
    private int solve(int length,int[] dp)
    {
        if(length>h)
            return 0;
        if(dp[length]!=-1)
            return dp[length];
        int a=0;
        if(length>=l)
        a=1;
        int addOne=solve(length+o,dp);
        int addzero=solve(length+z,dp);
        return dp[length]=(a+addOne+addzero)%mod;
    }
}