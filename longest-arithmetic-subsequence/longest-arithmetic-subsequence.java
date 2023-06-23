class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2)
        return n;

        int max=2;

        HashMap<Integer, Integer>[] dp= new HashMap[n];

        for(int i=0;i<n;i++)
        {
            dp[i]=new HashMap<>();
            for(int j=0;j<i;j++)
            {
                int diff=nums[i]-nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff,1)+1);
                max=Math.max(max,dp[i].get(diff));
            }
        }
        return max;
    }
}