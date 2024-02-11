class Solution {
    public int cherryPickup(int[][] grid) {
        int row = grid.length , col = grid[0].length;
        Integer[][][] dp = new Integer[row][col][col];
        for(int r = row - 1 ; r >= 0 ; r--){
            for(int c1 = 0 ; c1 < col ; c1++){
                for(int c2 = 0 ; c2 < col ; c2++){
                    int curr = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
                    if(r == row - 1){
                        dp[r][c1][c2] = curr;
                        continue;
                    }
                    int maxFromBottom = 0;
                    for(int i = -1 ; i <= 1 ; i++){
                        for(int j = - 1 ; j <= 1 ; j++){
                            int nextC1 = c1 + i;
                            int nextC2 = c2 + j;
                            if(nextC1 >= 0 && nextC1 < col && nextC2 >= 0 && nextC2 < col){
                                maxFromBottom = Math.max(maxFromBottom , dp[r + 1][nextC1][nextC2]);
                            }
                        }
                    }
                    dp[r][c1][c2] = curr + maxFromBottom;
                }
            }
        }
        return dp[0][0][col - 1];
    }
}