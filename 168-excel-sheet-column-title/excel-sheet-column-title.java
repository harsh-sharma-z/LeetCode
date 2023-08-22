class Solution {
    public String convertToTitle(int n) {
        String s = "";
        while(n > 0){
            n--;
            int curr = n % 26;
            n /= 26;
            // curr = curr == 0 ? 26 : curr; 
            s = s + (char)('A' + curr);
        }
        String ans = "";
        for(int i = s.length() - 1 ; i >= 0 ; i--)
            ans = ans + s.charAt(i);
        return ans;
    }
}