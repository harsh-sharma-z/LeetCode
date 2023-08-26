class Solution {
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs , (int[] a , int[] b) -> a[0] - b[0]);
        n = pairs.length;
        dp = new int[n + 1][n + 1];
        for(int[] i : dp)
            Arrays.fill(i , -1);
        return lis(pairs , -1 , 0);
    }
    private int lis(int[][] nums , int prev , int curr){
        if(curr == n)
            return 0;

        if(prev != -1 && dp[prev][curr] != -1)
            return dp[prev][curr];
        
        int taken = 0;
        if(prev == -1 || nums[curr][0] > nums[prev][1])
            taken = 1 + lis(nums , curr , curr + 1);
        
        int nottaken = lis(nums , prev , curr + 1);

        if(prev != -1)
            dp[prev][curr] = Math.max(taken , nottaken);

        return Math.max(taken , nottaken);
    }
}