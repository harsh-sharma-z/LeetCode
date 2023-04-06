class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<dp.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                    dp[i]=Math.max(dp[j]+1,dp[i]);
            }
        }
        int max=dp[0];
        for(int i:dp)
            max=Math.max(i,max);
        
        return max;
    }
}