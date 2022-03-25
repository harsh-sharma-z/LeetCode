class Solution {
    public boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        StringBuilder str= new StringBuilder(s);
        str.reverse();
        String s1=str.toString();
        if(s.equals(s1))
            return true;
        else
            return false;
        
    }
}
