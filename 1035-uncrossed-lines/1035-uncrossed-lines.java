class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int[][] dp=new int[l1+1][l2+1];
        
        for(int i=l1-1;i>=0;i--)
        {
            for(int j=l2-1;j>=0;j--)
            {
                int ans=0;
                if(nums1[i]==nums2[j])
                    ans=1+dp[i+1][j+1];
                else
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
}