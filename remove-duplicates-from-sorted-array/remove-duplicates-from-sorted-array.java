class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=0;
        int n=nums.length;
        if(n==0 || n==1)
        return n;
        int c=1;
        while(j<n)
        {
            if(nums[i]!=nums[j])
            {
                nums[++i]=nums[j];
                c++;
            }
            j++;
        }
        return c;
    }
}