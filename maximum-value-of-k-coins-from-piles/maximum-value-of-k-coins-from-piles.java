class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        Integer[][] dp=new Integer[piles.size()+1][k+1];
        return help(0,k,piles,dp);
    }
    int help(int i,int k, List<List<Integer>> piles,Integer[][] dp)
    {
        if(i>=piles.size() || k==0)
        return 0;
        if(dp[i][k]!=null)
        return dp[i][k];
        int notPick=help(i+1,k,piles,dp);
        int pick=0;
        int sum=0;
        for(int j=0;j<Math.min(k,piles.get(i).size());j++)
        {
            sum+=piles.get(i).get(j);
            pick=Math.max(pick,sum+help(i+1,k-(j+1),piles,dp));
        }
        return dp[i][k]=Math.max(pick,notPick);
    }

}