class Solution {
    int n;
    int dp[][]=new int[501][501];
    public int maxSatisfaction(int[] satisfaction) {
        n=satisfaction.length;
        Arrays.sort(satisfaction);
        for(int a[]:dp)
            Arrays.fill(a,-1);
        return solve(0,1,satisfaction);
    }
    
    private int solve (int i, int t, int[] satisfaction)
    {
        if(i>=n)
            return 0;
        if(dp[i][t]!=-1)
            return dp[i][t];
        
        int include= satisfaction[i]*t + solve(i+1,t+1,satisfaction);
        
        int exclude= solve(i+1,t,satisfaction);
        
        return dp[i][t]=Math.max(include,exclude);
    }
}