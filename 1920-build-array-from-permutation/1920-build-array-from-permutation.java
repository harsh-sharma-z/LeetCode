class Solution {
    public int[] buildArray(int[] nums) {
        int length=nums.length;
        int arr[]=new int[length];
        
        for(int i=0;i<length;i++)
        {
            arr[i]=nums[nums[i]];
        }
        
        return arr;
    }
}