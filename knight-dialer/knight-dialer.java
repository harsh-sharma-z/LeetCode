class Solution {
    public int knightDialer(int n) {
        int ans=0;
        int[][][] dp=new int[n][4][3];
        for(int i[][]:dp)
        for(int j[]:i)
        Arrays.fill(j,-1);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
                ans=(ans+help(n-1,i,j,dp))%1000000007;
            }
        }
        return (int)(ans%1000000007);
    }
    private int help(int n, int cr,int cc,int[][][] dp)
    {
        if((cc<0 || cr<0 || cr>=4 || cc>=3) || (cr==3 && cc==0)|| (cr==3 && cc==2))
        return 0;
        if(n==0)
        return 1;
        if(dp[n][cr][cc]!=-1)
        return dp[n][cr][cc];
        int[] r={-2,-2,2,2,-1,1,-1,1};
        int[] c={-1,1,-1,1,-2,-2,2,2};
        long ans=0;
        for(int i=0;i<c.length;i++)
        {
            ans+=(help(n-1,cr+r[i],cc+c[i],dp)%1000000007);
        }
        return dp[n][cr][cc]=(int)(ans%1000000007);
    }
}