class Solution {
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        int len = nums.length;
        for (int ele : nums)
            totalXor ^= ele;
        if (totalXor != 0)
            return len;
        for (int ele : nums) {
            if (ele == 0)
                continue;
            totalXor ^= ele;
            len--;
            if (totalXor != 0)
                return len;
        }
        return 0;
    }
}