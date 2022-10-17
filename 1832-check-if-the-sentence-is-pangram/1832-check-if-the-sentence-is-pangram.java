class Solution {
    public boolean checkIfPangram(String s) {
       Set<Character> uwu=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            uwu.add(s.charAt(i));
        }
        return uwu.size()==26;
    }
}