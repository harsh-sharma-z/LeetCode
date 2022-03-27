class Solution {
    public int maxSubArray(int[] nums) {
        int ans=0;
        int c=0;
        if(nums.length==1)
            return nums[0];
        else
        {
        
        for(int i:nums)
        {
            if(c<0)
                c=0;
            c+=i;
            if(ans<c)
                ans=c;
        }
        }
        return ans;
        
    }
}
