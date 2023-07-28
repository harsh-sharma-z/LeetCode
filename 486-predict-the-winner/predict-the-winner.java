class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] i : dp)
            Arrays.fill(i , -1);
        int p1 = solve(nums , 0 , nums.length-1 , dp);
        int s = 0;
        for(int i : nums)
            s += i;
        return p1 >= (s - p1);
    }
    private int solve(int[] nums , int i , int j ,int[][] dp){
        if(i > j)
            return 0;
        if(i == j)
            return nums[i];
        if(dp[i][j] != -1)
            return dp[i][j];    
        int take_i = nums[i] + Math.min(solve(nums , i+2 , j , dp) , solve(nums , i+1 , j-1 , dp));
        int take_j = nums[j] + Math.min(solve(nums , i+1 , j-1 , dp) , solve(nums , i , j-2 , dp));
        return dp[i][j] = Math.max(take_i , take_j);
    }
}