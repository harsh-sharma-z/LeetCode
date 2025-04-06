class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE , pro = 0;

        for(int i : prices) {
            min = Math.min(min , i);
            pro = Math.max(pro , i - min);
        }

        return pro;
    }
}