class Solution {
    public int[] getConcatenation(int[] nums) {
        int l=nums.length;
        int ans[]=new int[2*l];
        
        for(int i=0;i<l;i++)
        {
            ans[i]=nums[i];
            ans[i+l]=nums[i];
        }
        return ans;
        
    }
}