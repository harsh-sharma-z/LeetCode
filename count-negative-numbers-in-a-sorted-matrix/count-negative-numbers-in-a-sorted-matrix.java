class Solution {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; ++i) {
            // add up negative numbers of each row
            res += negativeEachRow(grid[i]);
        }
        return res;
    }
    private int negativeEachRow(int[] row) {
        int res = 0;
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // if midPoint is positive, go to the right side
            // if midPoint is negative, count the right side(because they are all negative) and go to left side.
            if (row[mid] >= 0) {
                l = mid + 1;
            } else if (row[mid] < 0) {
                res += r - mid + 1;
                r = mid - 1;
            }
        }
        return res;
    }
}