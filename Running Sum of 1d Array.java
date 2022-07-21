class Solution {
    public int[] runningSum(int[] nums) {
        int l=nums.length;
        int sum=0;
        int ans[]=new int[l];
        
        for(int i=0;i<l;i++)
        {
            sum+=nums[i];
            ans[i]=sum;
        }
        return ans;
        
    }
}
