class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] % 2 == 0) count +=nums[j];
        }
        int[] ans = new int[nums.length];
        for (int i = 0;i<nums.length;i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            int num = nums[index];
            nums[index] = num + val;
            if ((nums[index] % 2 == 0 && num % 2 != 0) ) {
                count = count + nums[index];
                ans[i] = count;
            }else if(nums[index] % 2 != 0 && num % 2 == 0){
                count = count - num;
                ans[i] = count;
            }else if(nums[index] % 2 == 0 && num % 2 == 0){
                count = count  + val;
                ans[i] = count;
            }else {
                ans[i] = count;
            }
        }
        return ans;
    }
}