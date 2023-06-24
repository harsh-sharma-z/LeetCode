class Solution {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        rev(nums, 0, nums.length-k-1);
        rev(nums, nums.length-k, nums.length-1);
        rev(nums,0,nums.length-1);
    }

    private void rev(int[] arr, int l , int r)
    {
        while(l<=r)
        {
            int temp=arr[l];
            arr[l++]=arr[r];
            arr[r--]=temp;
        }
    }
}