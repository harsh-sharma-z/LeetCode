class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int[] i : dp)
            Arrays.fill(i , -1);
        return dfs(obstacleGrid , 0 , 0 , n , m , dp);
    }

    private int dfs(int[][] a , int x , int y , int n , int m , int[][] dp){
        if(x >= n || y >= m || a[x][y] == 1) return 0;
        if(dp[x][y] != -1) return dp[x][y];
        if(x == n-1 && y == m-1) return dp[x][y] = 1;
        a[x][y] = 1;
        int ans = dfs(a , x + 1 , y , n , m , dp) + dfs(a , x , y + 1 , n , m , dp);
        a[x][y] = 0;
        return dp[x][y] = ans;
    }
}