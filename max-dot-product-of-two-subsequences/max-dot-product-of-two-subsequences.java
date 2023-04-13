class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2 ) {
        // int dp[][]=new int[nums1.length+1][nums2.length+1];
        // return help(nums1,nums2,0,0,true,dp);

        return helpBU(nums1,nums2);
    }
    // private int help(int[] nums1, int[] nums2, int i,int j, boolean flag,int[][] dp)
    // {
    //     if(i==nums1.length || j==nums2.length)
    //     {
    //         if(flag)
    //             return 0;
    //         else
    //             return -10000000;
    //     }
    //     if(dp[i][j]!=0)
    //         return dp[i][j];
    //     int dot= nums1[i]*nums2[j]+(help(nums1,nums2, i+1,j+1,true,dp));
    //     int fd=help(nums1,nums2, i+1,j,false,dp);
    //     int sd=help(nums1,nums2, i,j+1,false,dp);
    //     return dp[i][j]=Math.max(nums1[i]*nums2[j],Math.max(dot,Math.max(fd,sd)));
    // }
    
    private int helpBU(int[] nums1, int[] nums2)
    {
        int[][] dp=new int[nums1.length+1][nums2.length+1];
        int sp=Integer.MIN_VALUE;
        for(int i=1;i<=nums1.length;i++)
        {
            for(int j=1;j<=nums2.length;j++)
            {
                int dot=nums1[i-1]*nums2[j-1]+dp[i-1][j-1];
                int fd=dp[i-1][j];
                int sd=dp[i][j-1];

                dp[i][j]=Math.max(nums1[i-1]*nums2[j-1],Math.max(dot, Math.max(fd,sd)));
                sp=Math.max(sp,nums1[i-1]*nums2[j-1]);

            }
        }

        if(dp[dp.length-1][dp[0].length-1]==0)
        return sp;


        return dp[dp.length-1][dp[0].length-1];
    }
    
}