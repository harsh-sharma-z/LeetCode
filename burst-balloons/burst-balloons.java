class Solution {
    public int maxCoins(int[] nums) {
        int[] arr=new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        int i=1;
        for(int k:nums)
        arr[i++]=k;
        // int[] dp=new int[arr.length+1];
        // Arrays.fill(dp,-1);
        return burst(arr);
        
    }

    //top-down
    // private int burst(int[] arr, int si,int ei,int[] dp)
    // {
    //     if(si+1==ei)
    //     return 0;
    //     if(dp[si]!=-1)
    //     return dp[si];
    //     int ans=Integer.MIN_VALUE;
    //     for(int k=si+1;k<ei;k++)
    //     {
    //         int left=burst(arr,si,k,dp);
    //         int right=burst(arr,k,ei,dp);
    //         int self=arr[si]*arr[k]*arr[ei];
    //         ans=Math.max(ans,left+self+right);
    //     }
    //     return dp[si]=ans;
    // }


    //bottom-up
    private int burst(int[] arr)
    {
        int[][] dp=new int[arr.length][arr.length];
        for(int slide=2;slide<dp.length;slide++)
        {
            for(int j=slide;j<dp.length;j++)
            {
                int i=j-slide;
                int ans=Integer.MIN_VALUE;
                for(int k=i+1;k<j;k++)
                {
                    int left=dp[i][k];
                    int right=dp[k][j];
                    int self=arr[i]*arr[k]*arr[j];
                    ans=Math.max(ans,self+left+right);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][dp.length-1];
    }

}