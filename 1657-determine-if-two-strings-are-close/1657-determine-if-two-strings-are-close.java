class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] charCount1 = new int[26];
        int[] charCount2 = new int[26];

        for (char c : word1.toCharArray()) {
            charCount1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            charCount2[c - 'a']++;
        }

        for (int i = 0; i < charCount1.length; i++) {
            if (charCount1[i] > 0 ^ charCount2[i] > 0) return false;
        }

        Arrays.sort(charCount1);
        Arrays.sort(charCount2);

        return Arrays.equals(charCount1, charCount2);
    }
}