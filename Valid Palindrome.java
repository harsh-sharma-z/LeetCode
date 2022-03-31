class Solution {
    public boolean isPalindrome(String s) {
        int len=s.length(),i=0,j=len-1;
        
        while (i<j)
        {
            if (!Character.isLetterOrDigit(s.charAt(i)))
                ++i;
            else if (!Character.isLetterOrDigit(s.charAt(j)))
                --j;
            else if                                                      (Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
                return false;
            else
            {
                ++i;
                --j;
            }
        }
        
        return true;
        
    }
}
