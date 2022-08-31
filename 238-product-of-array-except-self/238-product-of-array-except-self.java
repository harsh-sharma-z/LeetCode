class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];

        int pl=1,pr=1;
        for(int i=0;i<n;i++)
        {
            left[i]=pl;
            pl*=nums[i];
            right[n-i-1]=pr;
            pr*=nums[n-i-1];
        }

        


        for(int i=0;i<n;i++)
        nums[i]=left[i]*right[i];

        return nums;
        
        
    }
}