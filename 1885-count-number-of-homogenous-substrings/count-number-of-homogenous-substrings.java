class Solution {
    public int countHomogenous(String s) {
        int mod = 1000_000_007;
        int ans = 0;
        int len = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(i > 0 && s.charAt(i) == s.charAt(i - 1)){
                len++;
            }
            else{
                len = 1;
            }
            ans = (ans + len) % mod;
        }
        return ans;
    }
}