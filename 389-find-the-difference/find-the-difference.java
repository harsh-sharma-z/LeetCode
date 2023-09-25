class Solution {
    public char findTheDifference(String s, String t) {
        long xor = 0 ;
        for(int i = 0 ; i < s.length() ; i++)
            xor = xor ^ (int)s.charAt(i);

        for(int i = 0 ; i < t.length() ; i++)
            xor = xor ^  (int)t.charAt(i);

        return (char)xor;
    }
}