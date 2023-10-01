class Solution {
    public String reverseWords(String s) {
        int i = 0  , j = 0;
        String ans = "";
        while(j < s.length()){
            if(s.charAt(j) == ' '){
                for(int k = j - 1 ; k >= i ; k--)
                    ans = ans + s.charAt(k);
                if(i == 0)
                    ans = ans + ' ';
                i = j;
            }
            j++;
        }
        for(int k = j - 1 ; k > (i == 0 ? -1 : i) ; k--)
            ans = ans + s.charAt(k);
        return ans;
    }
}