class Solution {
    private int[] dp;
    private int solve(int[] nums, int t){
        if(t < 0)
            return 0;
        if(t == 0)
            return 1;
        if(dp[t] != -1)
            return dp[t];
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            ans += solve(nums , t - nums[i]);
        }
        return dp[t] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp , -1);
        return solve(nums , target);
    }
}