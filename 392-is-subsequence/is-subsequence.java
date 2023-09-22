class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve( 0 , s , 0 , t);
    }
    private boolean solve(int i , String s , int j , String t){
        if(i == s.length())
            return true;
        if(i < s.length() && j >= t.length())
            return false;
        if(s.charAt(i) == t.charAt(j))
            return solve(i + 1 , s , j + 1 , t);
        else
            return solve(i , s , j + 1 , t);
    }
}