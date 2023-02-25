class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
    int totalProfit = 0;
    for (int i = 0; i < prices.length; i++) {
        min = Integer.min(min, prices[i]);
        int profit = prices[i] - min;
        totalProfit = Integer.max(totalProfit, profit);
    }
    return totalProfit;
    }
}