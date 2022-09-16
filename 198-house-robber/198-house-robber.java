class Solution {
    public int rob(int[] nums) {
        int pick=0;
        int notpick=0;
        
        for(int i:nums)
        {
            int temp=notpick;
            notpick=Math.max(pick,notpick);
            pick=i+temp;
        }
        return Math.max(pick,notpick);
    }
 
}