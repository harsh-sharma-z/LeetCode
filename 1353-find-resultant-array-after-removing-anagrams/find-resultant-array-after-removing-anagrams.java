class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;

        List<Map<Character , Integer>> count = new ArrayList<>();
        for(String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c : w.toCharArray()) {
                map.put(c , map.getOrDefault(c , 0) + 1);
            }
            count.add(map);

            
        }

        List<String> ans = new ArrayList<>();

        ans.add(words[0]);

        for(int i = 1 ; i < n ; i++) {
            if(!count.get(i).equals(count.get(i - 1))){
                ans.add(words[i]);
            }
        }

        return ans;
    }
}