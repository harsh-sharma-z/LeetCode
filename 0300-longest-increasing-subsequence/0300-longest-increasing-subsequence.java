class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int len=1;
        
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>dp[len-1])
            {
                dp[len]=nums[i];
                len++;
            }
            else
            {
                int ith=Search(dp,0,len-1, nums[i]);
                dp[ith]=nums[i];
            }
        }
        return len;
    }
    private int Search(int[] dp , int si, int ei, int k)
    {
        int ans=0;
        while(si<=ei)
        {
            int mid=(si+ei)/2;
            if(dp[mid]>=k)
            {
                ans=mid;
                ei=mid-1;
            }
            else
            {
                si=mid+1;   
            }
        }
        return ans;
    }
}