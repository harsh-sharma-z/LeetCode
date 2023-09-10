class Solution {
    public int countOrders(int n) {
        int mod = 1000_000_007;
        if(n == 1)
            return 1;
        
        long res = 1;

        for(int i = 2 ; i <= n ; i++){
            int spaces = (i - 1) * 2 + 1;
            int possibility = spaces * (spaces + 1) / 2;
            res *= possibility;
            res %= mod;
        }
        return (int)res % mod;
    }
}