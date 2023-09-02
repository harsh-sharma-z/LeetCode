class Solution {
    int n;
    HashSet<String> dict;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        dict = new HashSet<>(); // for quick access
        dp = new int[n + 1];
        Arrays.fill(dp , -1);
        for(String a : dictionary)
            dict.add(a);
        return solve(0 , s);
    }
    private int solve(int idx , String s){
        if(idx >= n)
            return 0; // no extra character required

        if(dp[idx] != -1)
            return dp[idx];
        
        String currString = "";
        int minExtra = n;

        for(int i = idx ; i < n ; i++){
            currString = currString + s.charAt(i);
            int currExtra = dict.contains(currString) ? 0 : currString.length();
            
            int nextExtra = solve(i + 1 , s);

            int totalExtra = currExtra + nextExtra;

            minExtra = Math.min(minExtra , totalExtra);
        }

        return dp[idx] = minExtra;
    }
}