class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

		for (String str : strs) {
			HashMap<Character, Integer> fmap = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
			}
			if (!map.containsKey(fmap)) {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(fmap, al);
			} else {
				List<String> al = map.get(fmap);
				al.add(str);
				map.put(fmap, al);
			}

		}
		List<List<String>> ans = new ArrayList();
		for (List<String> al : map.values()) {
			ans.add(al);
		}
		return ans;
        
    }
}