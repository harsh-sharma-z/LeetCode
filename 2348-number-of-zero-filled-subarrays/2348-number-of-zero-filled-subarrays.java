class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        long c=0;
        for(int i:nums)
        {
            if(i==0)
            {
                c++;
                ans+=c;
            }
            else
                c=0;
        }
        return ans;
    }
}