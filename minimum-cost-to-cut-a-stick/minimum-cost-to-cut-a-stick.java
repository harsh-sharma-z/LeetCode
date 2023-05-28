class Solution {
    int dp[][]=new int[103][103];
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cut=new int[cuts.length+2];
        cut[0]=0;
        cut[cut.length-1]=n;
        int j=1;
        for(int i:cuts)
        cut[j++]=i;
        for(int i[]:dp)
        Arrays.fill(i,-1);
        return solve(cut,0,cut.length-1);
    }
    private int solve(int[] cuts, int l, int r)
    {
        if(r-l<2)
        return 0;
        if(dp[l][r]!=-1)
        return dp[l][r];
        int res=Integer.MAX_VALUE;
        //l=starting value of stick
        //r=ending valeu of stick
        for(int index=l+1;index<=r-1;index++)
        {
            int cost=(cuts[r]-cuts[l])+solve(cuts,l,index)+solve(cuts,index,r);
            res=Math.min(res,cost);
        }
        return dp[l][r]=res;
    }
}