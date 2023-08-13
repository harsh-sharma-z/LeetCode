class Solution {
    private int n;
    public boolean validPartition(int[] nums) {
        n = nums.length;
        int[] dp = new int[100001];
        Arrays.fill(dp , -1);
        return solve(nums , 0 , dp);
    }
    private boolean solve(int[] nums , int i , int[] dp){
        if(i >= n)  return true;
        if(i == n - 1)  return false;
        if(dp[i] != -1){
            return dp[i] == 1;
        }
        boolean res = false;

        if(i + 2 < n){
            if(nums[i] == nums[i + 1]){
                if(nums[i + 1] == nums[i + 2]){
                    res = res || solve(nums , i + 3 , dp);
                }
                res = res || solve(nums , i + 2 , dp);
            }
            if(nums[i] == nums[i + 1] - 1){
                if(nums[i] == nums[i + 2] - 2){
                    res = res || solve(nums , i + 3 , dp);
                }
            }
        }
        else{
            res = res || (nums[i] == nums[i + 1] && solve(nums , i + 2 , dp));
        }
        dp[i] = res ? 1 : 0;
        return res;
    }
}