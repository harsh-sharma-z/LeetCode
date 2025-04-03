class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];

        for(int i = 1 ; i < n ; i++) {
            left[i] = Math.max(left[i - 1] , nums[i]);
        }

        for(int j = n - 2 ; j >=0. ; j--) {
            right[j] = Math.max(right[j + 1] , nums[j]);
        }

        long ans = 0;

        for(int i = 1 ; i < n - 1 ; i++) {
            int l = left[i - 1];
            int r = right[i + 1];

            ans = Math.max(ans , (long)(l - nums[i]) * r);
        }

        return ans;
    }
}