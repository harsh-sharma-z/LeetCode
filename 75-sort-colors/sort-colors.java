class Solution {
    public void sortColors(int[] nums) {
        int left = 0 ,  right = nums.length - 1 , i = 0;

        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums , left , i);
                left++;
                i++;
                continue;
            }
            if(nums[i] == 2) {
                swap(nums , right , i);
                right--;
                continue;
            }
            i++;
        }
    }
    private void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}