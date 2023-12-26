class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int dp[][] = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                for(int val=1;val<=k;val++){
                    if(j>=val){
                        dp[i][j] = dp[i-1][j-val]%mod + dp[i][j]%mod;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return dp[n][target]%mod;
    }
}