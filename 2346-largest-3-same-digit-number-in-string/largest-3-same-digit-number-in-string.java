class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1;
        for(int i = 0 ; i + 2 < num.length() ; i++){
            if(num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)){
                ans = Math.max(ans , num.charAt(i) - '0');
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < 3 ; i++)
            res.append((char)(48 + ans));
        return ans == -1 ? "" : res.toString();
    }
}