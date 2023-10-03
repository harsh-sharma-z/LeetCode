class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer , Integer> uwu = new HashMap<>();
        int ans = 0;
        for(int i : nums){
            if(uwu.containsKey(i)){
                ans += uwu.get(i);
            }
            uwu.put(i , uwu.getOrDefault(i , 0) + 1);
        }
        return ans;
    }
}