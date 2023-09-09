class Solution {
    //private int[] dp;
    //memoization
    // private int solve(int[] nums, int t){
    //     if(t < 0)
    //         return 0;
    //     if(t == 0)
    //         return 1;
    //     if(dp[t] != -1)
    //         return dp[t];
    //     int ans = 0;
    //     for(int i = 0 ; i < nums.length ; i++){
    //         ans += solve(nums , t - nums[i]);
    //     }
    //     return dp[t] = ans;
    // }

    //tabulation
    private int solveTab(int[] nums , int t){
        int[] dp = new int[t + 1];
        dp[0] = 1;
        for(int i = 1 ; i <= t ; i++){
            //traverse on the nums array
            for(int j : nums){
                if(i - j >= 0)
                    dp[i] += dp[i - j];
            }
        }
        return dp[t];
    }
    public int combinationSum4(int[] nums, int target) {
        // dp = new int[target + 1];
        // Arrays.fill(dp , -1);
        // return solve(nums , target);
        return solveTab(nums , target);
    }
}