class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        for(int i = 0 ; i < chars.length() ; i++)
            freq[chars.charAt(i) - 'a']++;
        
        int ans = 0;

        for(String s : words){
            if(check(s , freq))
                ans += s.length();
        }

        return ans;
    }

    boolean check(String word , int[] freq){
        int[] c = new int[26];

        for(int i = 0 ; i < word.length() ; i++){
            int x = word.charAt(i) - 'a';
            c[x] ++;
            if(c[x] > freq[x])
                return false;
        }
        return true;
    }
}