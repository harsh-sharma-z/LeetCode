class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[2];

        for(int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            int needed = target - num;

            if(map.containsKey(needed)) {
                ans[0] = map.get(needed);
                ans[1] = i;

                return ans;
            }

            map.put(num , i);
        }

        return ans;
    }
}