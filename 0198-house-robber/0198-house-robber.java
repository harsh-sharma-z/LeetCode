class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return robberTD(nums,0,dp);  
    }
    // private int robber(int[] nums, int i)
    // {
    //     if(i>=nums.length)
    //         return 0;
    //     int yes=nums[i]+robber (nums,i+2);
    //     int no=robber(nums, i+1);
    //     return Math.max(yes,no);
    // }
    
    private int robberTD(int[] nums, int i,int[] dp)
    {
        if(i>=nums.length)
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        int yes=nums[i]+robberTD (nums,i+2,dp);
        int no=robberTD(nums, i+1,dp);
        return dp[i]=Math.max(yes,no);
    }
    
}