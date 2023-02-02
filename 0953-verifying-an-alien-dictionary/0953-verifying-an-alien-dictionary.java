class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int map[]=new int[26];
        int s=0;
        for(char c:order.toCharArray())
        {
            map[c-'a']=s++;
        }
        
        for(int i=0;i<words.length-1;i++)
        {
            String curr=words[i];
            String next=words[i+1];
            
            int len=Math.min(curr.length(),next.length());
            if(len!=curr.length() && len==next.length() && curr.startsWith(next))
                return false;
            
            for(int j=0;j<len;j++)
            {
                if(map[curr.charAt(j)-'a']>map[next.charAt(j)-'a'])
                    return false;
                if(map[curr.charAt(j)-'a']<map[next.charAt(j)-'a'])
                    break;
            }
        }
        return true;
    }
}