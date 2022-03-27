class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        return (str.length()-str.lastIndexOf(" ")-1);
        
    }
}
