class Solution {
    public void rotate(int[] nums, int k) {
        
        if(nums==null || nums.length<2)
            return;
        
        k%=nums.length;
        
        
        help(nums,0,nums.length-k-1);
        help(nums,nums.length-k,nums.length-1);
        help(nums,0,nums.length-1);
        
    }
    
    public void help(int[] nums,int i,int j)
    {
        int temp=0;
        
        while(i<j)
        {
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            
            i++;
            j--;
            
        }
    }
}