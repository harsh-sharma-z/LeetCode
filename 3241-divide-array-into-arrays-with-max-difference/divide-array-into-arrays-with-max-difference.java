class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort to group close elements
        int ptr = 0;
        int[][] result = new int[nums.length / 3][3];

        for (int[] arr : result) {
            for (int i = 0; i < 3; i++) {
                arr[i] = nums[ptr++];
            }
            // Check the max-min condition
            if (arr[2] - arr[0] > k) return new int[][]{};
        }

        return result;
    }
}