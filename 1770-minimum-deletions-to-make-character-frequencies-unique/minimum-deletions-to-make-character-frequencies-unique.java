class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;

        for(int i = 0 ; i < 26 ; i++){
            while(freq[i] > 0 && set.contains(freq[i])){
                freq[i]--;
                ans++;
            }
            set.add(freq[i]);
        }
        return ans;
    }
}