class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp , -1);
        return solve(0 , s , s.length() , wordDict , dp);
    }
    private boolean solve(int idx , String s , int n , List<String> dic , int[] dp){
        if(dp[idx] != -1){
            return dp[idx] == 1 ? true : false;
        }
        if(idx >= n){
            dp[idx] = 1;
            return true;
        }
        if(dic.contains(s)){
            dp[idx] = 1;
            return true;
        }

        for(int l = idx+1 ; l <= n ; l++){
            String temp = s.substring(idx , l);
            if(dic.contains(temp) && solve(l , s , n , dic , dp)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}