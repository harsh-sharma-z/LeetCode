class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int len=nums.length;
        int l=0;
        for(int i=0;i<len;i=i+2)
        {
            l+=nums[i];
        }
        
        int arr[]=new int[l];
        
        int h=0;
        for(int i=1,j=0;i<len;i=i+2,j=j+2)
        {
            for(int k=0;k<nums[j];k++ )
            {
                arr[h]=nums[i];
                h++;
            }
        }
        return arr;
        
    }
}
