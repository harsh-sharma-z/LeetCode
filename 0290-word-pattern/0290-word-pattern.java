class Solution {
    public boolean wordPattern(String pattern, String s) {
        String word[]=s.split(" ");
            if(word.length!=pattern.length())
                return false;
        Map uwu=new HashMap<>();
        for(Integer i=0;i<pattern.length();i++)
            if(uwu.put(pattern.charAt(i),i)!=uwu.put(word[i],i))
                return false;
        return true;
    }
}