class Solution {
    int N , M , K , MOD = 1000_000_007;
    int[][][] dp = new int[51][51][101];
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        for(int i[][] : dp)
            for(int j[] : i)
                Arrays.fill(j , -1);
        return solve(0 , 0 , 0);
    }

    private int solve(int idx , int searchCost , int max){
        if(idx >= N)
            return searchCost == K ? 1 : 0;

        if(dp[idx][searchCost][max] != -1)
            return dp[idx][searchCost][max] % MOD;

        int res = 0;
        for(int i = 1 ; i <= M ; i++){
            if(max < i)
                res = (res + solve(idx + 1 , searchCost + 1 , i)) % MOD;
            else
                res = (res + solve(idx + 1 , searchCost , max)) % MOD;
        }

        res %= MOD;

        return dp[idx][searchCost][max] = res;
    }
}