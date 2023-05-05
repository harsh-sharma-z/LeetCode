class Solution {
    int isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return 1;
        }
        return 0;
    }
     public int maxVowels(String s, int k) {
        int maxVowels = 0;
        int count = 0;
         for(int i = 0; i < k; i++) {
            char c = s.charAt(i);
            count += isVowel(c);
        }
        maxVowels = count;
         for(int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            count += isVowel(c) - isVowel(s.charAt(i-k));
            maxVowels = Math.max(maxVowels, count);
        }
         return maxVowels;
    }
}