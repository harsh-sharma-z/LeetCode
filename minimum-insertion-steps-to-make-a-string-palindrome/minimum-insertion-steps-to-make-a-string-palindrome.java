class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] sc = s.toCharArray();
        int[][] memo = new int[n][n];
        int ans = n - 1;
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, n - 1 - eliminate(sc, i - 1, i + 1, memo));
            if (i + 1 < n && sc[i] == sc[i + 1]) {
                ans = Math.min(ans, n - 2 - eliminate(sc, i - 1, i + 2, memo));
            }
        }
        return ans;
    }

    private int eliminate(char[] sc, int i1, int i2, int[][] memo) {
        if (i1 < 0 || i2 >= sc.length) {
            return 0;
        }
        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        int count = 0;
        if (sc[i1] != sc[i2]) {
            count = Math.max(eliminate(sc, i1, i2 + 1, memo), eliminate(sc, i1 - 1, i2, memo));
        } else {
            count = eliminate(sc, i1 - 1, i2 + 1, memo) + 2;
        }
        return memo[i1][i2] = count;
    }
}