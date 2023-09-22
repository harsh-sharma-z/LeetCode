class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0 , j = 0 , n = s.length() , m = t.length();
        while(i < n){
            if(j == m)
                return false;
            if(s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return true;
    }
}