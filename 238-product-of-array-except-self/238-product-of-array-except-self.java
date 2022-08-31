class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];

        int pl=1,pr=1;
        for(int i=0;i<nums.length;i++)
        {
            left[i]=pl;
            pl*=nums[i];
            right[nums.length-i-1]=pr;
            pr*=nums[nums.length-i-1];
        }

        


        for(int i=0;i<nums.length;i++)
        nums[i]=left[i]*right[i];

        return nums;
        
        
    }
}