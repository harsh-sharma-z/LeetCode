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
        for(int i=0;i<len;i=i+2)
        {
            Arrays.fill(arr, h,h + nums[i], nums[i + 1]);
            h+= nums[i];
        }
        return arr;
        
    }
}
