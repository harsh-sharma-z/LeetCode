class Solution {
    public int[] twoSum(int[] nums, int target) {
        int size=nums.length;
        int asn1,ans2;
        for(int i=0;i<size-1;i++)
        {
            for(int j=i+1;j<size;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    return new int[]  {i,j};
                }
            }
        }
        return new int[] {0,0};
        
    }
}
