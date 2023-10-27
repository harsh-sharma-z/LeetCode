class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        int start = 0;
        dp = new int[n][n];
        for(int[] i : dp)
            Arrays.fill(i , -1);
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPalindrome(s , i , j) && j - i + 1 > maxlen){
                    start = i;
                    maxlen = j - i + 1;
                }
            }
        }

        return s.substring(start , start + maxlen);
    }
    private boolean isPalindrome(String s , int l , int r){
        if(l >= r)
            return true;
        
        if(dp[l][r] != -1)
            return dp[l][r] == 1;

        if(s.charAt(l) == s.charAt(r))
            dp[l][r] = isPalindrome(s , l + 1 , r - 1) ? 1 : 0;
        else
            dp[l][r] = 0;
        
        return dp[l][r] == 1;
    }
}