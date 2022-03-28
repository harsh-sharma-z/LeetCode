class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int start = 0, end = 0;

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (end = 0; end < len; end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

            while (end-start+1 > map.size()) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }

            maxLen = Math.max(maxLen, end-start+1);
        }

        return maxLen;
        
    }
}
