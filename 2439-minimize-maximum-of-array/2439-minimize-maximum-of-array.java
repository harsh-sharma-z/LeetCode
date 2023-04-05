class Solution {
    public int minimizeArrayValue(int[] nums) {
        long s=0,ans=0;
        for(int i=0;i<nums.length;i++)
        {
            s+=nums[i]; //prefix sum nikalenge
            ans=Math.max(ans, (s+i)/(i+1)); //ceil average
        }
        return (int)ans;
    }
}