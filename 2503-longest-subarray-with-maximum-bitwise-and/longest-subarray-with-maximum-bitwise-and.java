class Solution {
    public int longestSubarray(int[] nums) {
        int max=nums[0];
        for(int i:nums)
        {
            max=Math.max(max,i);
        }
        
        int ans = 1, temp = 1;
 
 
    for(int i = 1; i < nums.length; i++)
    {
        if(nums[i]==max)
        {
             if (nums[i] == nums[i - 1])
       {
           ++temp;
       }
       else
       {
           ans = Math.max(ans, temp);
           temp = 1;
       }
        }
      
    }
    ans = Math.max(ans, temp);
        return ans;
    }
}