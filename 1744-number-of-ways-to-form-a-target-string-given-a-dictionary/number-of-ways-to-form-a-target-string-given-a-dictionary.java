class Solution {
    int m, n;
    int MOD = 1000_000_007;
    public int helper(String[] words, String target, int wInd, int tInd, Integer[][] mem) {
        if(tInd == n)
            return 1;
        if(mem[wInd][tInd] != null)
            return mem[wInd][tInd];
        if(m-wInd < n-tInd)
            return mem[wInd][tInd] = 0;
        
        int ans = 0;
        ans = (ans%MOD + helper(words, target, wInd+1, tInd, mem)%MOD)%MOD;
        for(String word: words) {
            if(word.charAt(wInd) == target.charAt(tInd))
                ans = (ans%MOD + helper(words, target, wInd+1, tInd+1, mem)%MOD)%MOD;
        }
        return mem[wInd][tInd] = ans;
    }
    public int numWays(String[] words, String target) {
        m = words[0].length();
        n = target.length();
        return helper(words, target, 0, 0, new Integer[m+1][n+1]);
    }
}