class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        
        //return lcs(text1,text2,0,0);
        
        
        //return lcs2(text1,text2,text1.length()-1, text2.length()-1);
        
        
        return lcsBU(text1,text2);
        
        
//         int[][] dp=new int[text1.length()+1][text2.length()+1];
        
//         for(int[] a:dp)
//             Arrays.fill(a,-1);
        
//         return lcsTD(text1, text2, 0,0, dp);
        
    }
    
    
    
    
    private int lcs (String s1, String s2, int i, int j)
    {
        if(i==s1.length() || j==s2.length())
            return 0;
        
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j))
            ans=1+lcs(s1,s2,i+1,j+1);
        else
        {
            int fs=lcs(s1,s2,i+1,j);
            int ss=lcs(s1,s2,i,j+1);
            ans=Math.max(fs,ss);
        }
        return ans;
    }
    
    
    
    
    private int lcs2 (String s1, String s2, int i, int j)
    {
        if(i<0 || j<0)
            return 0;
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j))
            ans=1+lcs2(s1,s2,i-1,j-1);
        else
        {
            int fs=lcs2(s1,s2,i-1,j);
            int ss=lcs2(s1,s2,i,j-1);
            ans=Math.max(fs,ss);
        }
        return ans;
    }
    
    
    
    
    private int lcsTD (String s1, String s2, int i, int j,int[][] dp)
    {
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j))
            ans=1+lcsTD(s1,s2,i+1,j+1,dp);
        else
        {
            int fs=lcsTD(s1,s2,i+1,j,dp);
            int ss=lcsTD(s1,s2,i,j+1,dp);
            ans=Math.max(fs,ss);
        }
        return dp[i][j]=ans;
    }
    
    
    
    
    private int lcsBU (String s1, String s2)
    {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=s1.length()-1;i>=0;i--)
        {
            for(int j=s2.length()-1;j>=0;j--)
            {
                int ans=0;
                if(s1.charAt(i)==s2.charAt(j))
                    ans=1+dp[i+1][j+1];
                else
                {
                    int fs=dp[i+1][j];
                    int ss=dp[i][j+1];
                    ans=Math.max(fs,ss);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
}