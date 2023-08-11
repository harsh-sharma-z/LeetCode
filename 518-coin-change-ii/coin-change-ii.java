class Solution {
    public int change(int amount, int[] coins) {
        // return changeCoin(coins,amount,0);
        return changeBU(coins,amount);
    }

    // private int changeCoin(int[] coins, int amount, int idx)
    // {
    //     if(amount==0)
    //     {
    //         return 1;
    //     }
    //     if(idx==coins.length)
    //     {
    //         return 0;
    //     }
    //     int inc=0;
    //     int exc=0;
    //     if(coins[idx]<=amount)
    //     inc=changeCoin(coins,amount-coins[idx],idx);
    //     exc=changeCoin(coins, amount, idx+1);
    //     return inc+exc;
    // }

    private int changeBU(int[] coin,int amount)
    {
        int[][] dp=new int[coin.length+1][amount+1];
        for(int i=0;i<dp.length;i++)
        dp[i][0]=1;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                int inc=0,exc=0;
                if(coin[i-1]<=j)
                {
                    inc=dp[i][j-coin[i-1]];
                }
                exc=dp[i-1][j];
                dp[i][j]=inc+exc;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}