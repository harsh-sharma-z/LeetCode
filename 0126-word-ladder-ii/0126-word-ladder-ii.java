class Solution {
    String b;
    HashMap<String , Integer> mpp;
    
    List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st=new HashSet<>();
        // int len=wordList.size();
        
        for(String s: wordList)
            st.add(s);
        
        
        Queue<String> uwu=new LinkedList<>();
        b=beginWord;
        
        uwu.add(beginWord);
        
        mpp=new HashMap<>();
        
        mpp.put(beginWord,1);
        int sizee=beginWord.length();
        st.remove(beginWord);
        
        
        while(!uwu.isEmpty())
        {
            String word=uwu.peek();;
            
            int steps=mpp.get(word);
            
            uwu.remove();
            
            if(word.equals(endWord))
                break;
            
            for(int i=0;i<sizee;i++)
            {
                
                for(char c='a';c<='z';c++)
                {
                    char[] reparray=word.toCharArray();
                    reparray[i]=c;
                    
                    String rep=new String(reparray);
                    
                    if(st.contains(rep))
                    {
                        st.remove(rep);
                        uwu.add(rep);
                        mpp.put(rep,steps+1);
                    }
                }
            }
            
            ans=new ArrayList<>();
            
            if(mpp.containsKey(endWord))
            {
                List<String> seq=new ArrayList<>();
                seq.add(endWord);
                dfs(endWord,seq);
            }
        }
            
            return ans;
        }
        
        private void dfs(String word, List<String> seq)
        {
            
            if(word.equals(b))
            {
                List<String> dup=new ArrayList<>(seq);
                
                Collections.reverse(dup);
                
                
                ans.add(dup);
                
                return;
            }
            
            
            int steps=mpp.get(word);
            int sz=word.length();
            
            for(int i=0;i<sz;i++)
            {
                for(char c='a';c<='z';c++)
                {
                    char[] reparray= word.toCharArray();
                    reparray[i]=c;
                    
                    String rep=new String(reparray);
                    
                    
                    if(mpp.containsKey(rep) && mpp.get(rep)+1==steps)
                    {
                        seq.add(rep);
                        dfs(rep,seq);
                        seq.remove(seq.size()-1);
                    }
                }
            }
                
        }
    
}