class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i = n - 2 ; i >= 0 ; i --) {
            if(nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            reverse(nums , 0 , n - 1);
            return;
        }

        for(int i = n - 1 ; i > idx ; i --) {
            if(nums[i] > nums[idx]) {
                swap(nums , i , idx);
                break;
            }
        }

        reverse(nums , idx + 1 , n - 1);

         
    }

    void reverse(int[] nums , int i , int j) {
        while(i < j) {
            swap(nums , i , j);
            i++;
            j--;
        }
    } 

    void swap(int[] nums , int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}