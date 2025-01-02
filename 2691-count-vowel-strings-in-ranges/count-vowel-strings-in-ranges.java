class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];

        Set<Character> vowels = new HashSet<>(Arrays.asList('a' , 'e' , 'i' , 'o' , 'u'));

        for(int i = 0 ; i < n  ; i++) {
            prefix[i + 1] = prefix[i];
            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(words[i].length() - 1))) {
                prefix[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++) {
            ans[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }

        return ans;
    }
}