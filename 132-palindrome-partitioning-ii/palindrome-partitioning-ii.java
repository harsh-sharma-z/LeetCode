class Solution {
    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int[] ans = new int[n];

        boolean[][] dp = new boolean[n][n];

        for(int i = 0 ; i < n ; i ++) {
            int low = i;

            for(int j = 0 ; j <= i ; j ++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    low = j == 0 ? 0 : Math.min(low , ans[j - 1] + 1);
                }
            }

            ans[i] = low ;
        }

        return ans[n - 1];
    }
}