class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i : arr)
            freq.put(i , freq.getOrDefault(i , 0) + 1);
        return freq.size() == new HashSet<>(freq.values()).size();
    }
}