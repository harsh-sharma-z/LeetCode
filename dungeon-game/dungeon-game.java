class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int dp[][]=new int[dungeon.length+1][dungeon[0].length+1];
        for(int []i:dp)
        Arrays.fill(i,-1);
        return help(dungeon,0,0,dp);
    }
    private int help(int[][] d, int cr,int cc,int [][]dp)
    {
        if(cr==d.length || cc==d[0].length)
        return Integer.MAX_VALUE;
        if(cr==d.length-1  && cc==d[0].length-1)
        {
            return d[cr][cc]>0?1:1-d[cr][cc];
        }
        if(dp[cr][cc]!=-1)
        {
            return dp[cr][cc];
        }
        int r=help(d,cr,cc+1,dp);
        int dw=help(d,cr+1,cc,dp);
        int hp=Math.min(r,dw)-d[cr][cc];
        return dp[cr][cc]=hp>0?hp:1;
    }
}