class Solution {
    class Pair
    {
        String first;
        int second;
        public Pair(String first, int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> uwu=new LinkedList<>();
        
        uwu.add(new Pair(startWord, 1));
        
        Set<String> st=new HashSet<>();
        
        for(String w:wordList)
        st.add(w);
        
        st.remove(startWord);
        
        while(!uwu.isEmpty())
        {
            String word=uwu.peek().first;
            int steps=uwu.peek().second;
            uwu.remove();
            
            if(word.equals(targetWord))
            return steps;
            
            for(int i=0;i<word.length();i++)
            {
                for(char c='a'; c<='z';c++)
                {
                    char[] replace= word.toCharArray();
                    replace[i]=c;
                    
                    String rep=new String(replace);
                    
                    if(st.contains(rep))
                    {
                        st.remove(rep);
                        uwu.add(new Pair(rep,steps+1));
                    }
                }
            }
            
            
        }
        
        return 0;
        
    }
}