class Solution {
    private static final int mod = 1000000007;
    private static final int a = 0 , e = 1 , i = 2 , o = 3 , u = 4;
    private long[][] dp;
    public int countVowelPermutation(int n) {
        dp = new long[5][n + 1];
        for(long i[] : dp)
            Arrays.fill(i , -1);

        long res = 0; 

        res = (res + solve(a , n - 1)) % mod;
        res = (res + solve(e , n - 1)) % mod;
        res = (res + solve(i , n - 1)) % mod;
        res = (res + solve(o , n - 1)) % mod;
        res = (res + solve(u , n - 1)) % mod;

        return (int)res;
    }
    private long solve(int ch , int n){
        if(n == 0)
            return 1;

        if(dp[ch][n] != -1)
            return dp[ch][n];

        if(ch == a){
            return dp[ch][n] = solve(e , n -1) % mod;
        } else if(ch == e){
            return dp[ch][n] = (solve(a , n - 1) + solve(i , n - 1)) % mod;
        } else if(ch == i){
            return dp[ch][n] = (solve(a , n - 1) + solve(e , n - 1) + solve(o , n - 1) + solve(u , n - 1)) % mod;
        } else if(ch == o){
            return dp[ch][n] = (solve(i , n - 1) + solve(u , n - 1)) % mod;
        } else{
            return dp[ch][n] = solve(a , n - 1) % mod;
        }
    }
}