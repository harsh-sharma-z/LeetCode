class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
        return false;
        if(s.equals(goal))
        {
            HashSet<Character>  uwu=new HashSet<>();

            for(char c: s.toCharArray())
            uwu.add(c);

            return uwu.size()<s.length();
        }

        ArrayList<Integer> hash=new ArrayList<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=goal.charAt(i))
                hash.add(i);
        }

        if(hash.size()==2 && 
        s.charAt(hash.get(0))==goal.charAt(hash.get(1))
        && s.charAt(hash.get(1))==goal.charAt(hash.get(0)))
        return true;
        return false;
    }
}