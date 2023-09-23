class Solution {
    int n;
    public int longestStrChain(String[] words) {
        n = words.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int[] i : dp)
            Arrays.fill(i , -1);

        Arrays.sort(words , (String a , String b) -> a.length() - b.length());
        return lis(words , -1 , 0 , dp);
    }

    private int lis(String[] words , int prev , int curr , int[][] dp){
        if(curr >= n)
            return 0;
        
        if(prev != -1 && dp[prev][curr] != -1)
            return dp[prev][curr];
        
        int take = 0 , nottake;
        
        if(prev == -1 || isPred(words[prev] , words[curr]))
            take = 1 + lis(words , curr , curr + 1 , dp);

        nottake = lis(words , prev , curr + 1 , dp);

        if(prev != -1)
            dp[prev][curr] = Math.max(take , nottake);

        return Math.max(take , nottake);
    }

    private boolean isPred(String prev , String curr){
        int m = prev.length();
        int n = curr.length();

        if(m >= n || n - m != 1)
            return false;
        
        int i = 0 , j = 0;

        while(i < m && j < n){
            if(prev.charAt(i) == curr.charAt(j))
                i++;
            j++;
        }

        return i == m;
    }
}