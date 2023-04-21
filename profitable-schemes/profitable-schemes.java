class Solution {
    int MOD = 1000_000_007;
    public int helper(int[] group, int[] profit, int minProfit, int i, int n, Integer[][][] mem) {
        if(minProfit < 0)
            minProfit = 0;
        if(i == group.length || n == 0)
        	return minProfit==0?1:0;
        if(mem[minProfit][i][n] != null)
            return mem[minProfit][i][n];
        int exclude = helper(group, profit, minProfit,  i+1, n, mem);
        int include = 0;
        if(n>=group[i])
            include = helper(group, profit, minProfit-profit[i], i+1, n-group[i], mem);
        return mem[minProfit][i][n] = (exclude+include)%MOD;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return helper(group, profit, minProfit, 0, n, new Integer[minProfit+1][group.length][n+1]);
    }
}