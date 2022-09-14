class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        
        int p=1,l=0,r,ans=0;
        
        for(r=0;r<nums.length;r++)
        {
            p=p*nums[r];
            while(p>=k)
            {
                p=p/nums[l];
                l++;
            }
            ans+=r-l+1;
        }
        
        return ans;
    }
}