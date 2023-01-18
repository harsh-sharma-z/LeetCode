class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        HashMap<Integer,Integer> uwu=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(uwu.containsKey(target-nums[i])) {
                res[1]=i;
                res[0]=uwu.get(target-nums[i]);
            }
            uwu.put(nums[i],i);
        }
        return res;
    }
}