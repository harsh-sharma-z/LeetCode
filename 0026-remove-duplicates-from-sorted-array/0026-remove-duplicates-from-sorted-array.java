class Solution {
    public int removeDuplicates(int[] nums) {
        int c = 0;
      
        for (int i = 0; i < nums.length; i++) {

            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            // We will update the array in place
            nums[c] = nums[i];
            c++;
        }
        return c;
        
    }
}