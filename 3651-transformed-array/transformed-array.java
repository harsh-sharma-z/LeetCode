class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length , bias = n * (99 / n) + n;

        int[] ans = new int[n];

        for(int i = 0 ;  i < n ; i++) {
            ans[i] = nums[(i + nums[i] + bias) % n];
        } 

        return ans;
    }
}