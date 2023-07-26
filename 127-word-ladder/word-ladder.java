class Solution {
    class Pair{
        String str;
        int steps;
        public Pair(String a , int b){
            str = a;
            steps = b;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> uwu = new LinkedList<>();
        uwu.add(new Pair(beginWord , 1));

        Set<String> st = new HashSet<>();

        for(String s : wordList)
            st.add(s);
        
        st.remove(beginWord);

        while(!uwu.isEmpty()){
            Pair curr = uwu.poll();
            String currWord = curr.str;
            int steps = curr.steps;

            if(currWord.equals(endWord))
                return steps;
            
            for(int i = 0 ; i < currWord.length() ; i++){
                for(char c = 'a' ; c <= 'z' ; c++){
                    char[] arr = currWord.toCharArray();
                    arr[i] = c;

                    String newWord = new String(arr);

                    if(st.contains(newWord)){
                        st.remove(newWord);
                        uwu.add(new Pair(newWord , steps+1));
                    }
                }
            }
            
        }
        return 0;
    }
}