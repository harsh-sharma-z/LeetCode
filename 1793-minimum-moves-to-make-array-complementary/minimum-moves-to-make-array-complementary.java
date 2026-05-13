class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            // 1. Default: 2 moves for all possible sums [2, 2*limit]
            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // 2. Range for 1 move: [1 + min(a, b), limit + max(a, b)]
            // Reduce moves from 2 to 1 in this range
            int minPossibleWithOneChange = Math.min(a, b) + 1;
            int maxPossibleWithOneChange = Math.max(a, b) + limit;
            diff[minPossibleWithOneChange] -= 1;
            diff[maxPossibleWithOneChange + 1] += 1;

            // 3. Exact sum: a + b
            // Reduce moves from 1 to 0 for this specific sum
            int currentSum = a + b;
            diff[currentSum] -= 1;
            diff[currentSum + 1] += 1;
        }

        int minMoves = n; // Max possible moves is n
        int currentMoves = 0;
        // Sweep through all possible target sums from 2 to 2*limit
        for (int s = 2; s <= 2 * limit; s++) {
            currentMoves += diff[s];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}