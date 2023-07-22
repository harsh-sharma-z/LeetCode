class Solution {
    private int[][] direction = {{1 , 2} , {1 , -2} , {-1 , 2} , {-1 , -2} , {2 , 1} , {2 , -1} , {-2 , 1} , {-2 , -1}};

    double dp[][][];
    public double knightProbability(int n, int k, int row, int col) {
        dp = new double[n][n][k + 1];
        for(double a[][] : dp)
            for(double b[] : a)
                Arrays.fill(b , -1.0);
        double p = solve(row , col , k , n);
        double total = Math.pow(8 , k);
        return p / total;
    }
    private double solve(int r , int c , int k , int n){
        if(r < 0 || r >= n || c < 0 || c >= n){
            return 0;
        }
        if(k == 0){
            return 1;
        }
        
        if(dp[r][c][k] != -1.0){
            return dp[r][c][k];
        }

        double ans = 0;
        for(int[] dir : direction){
            int nr = r + dir[0];
            int nc = c + dir[1];

            ans += (double)(solve(nr , nc , k-1 , n));
        }

        return dp[r][c][k] = ans;
    }
}