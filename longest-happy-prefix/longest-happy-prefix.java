class Solution {
    public String longestPrefix(String s) {
        int[] dp=new int[s.length()];
        int len=0;
        for(int i=1;i<dp.length;)
        {
            if(s.charAt(len)==s.charAt(i))
            {
                len++;
                dp[i]=len;
                i++;
            }
            else
            {
                if(len>0)
                {
                    len=dp[len-1];
                }
                else
                {
                    dp[i]=0;
                    i++;
                }
            }
        }
        return s.substring(0,len);
    }
}