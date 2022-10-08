class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestsum = Integer.MAX_VALUE;
        for(int i=0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length - 1;
            int sum = 0;
            while(l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - sum) < Math.abs(closestsum))
                    closestsum = target - sum;
                if( sum < target )
                    l++;
                else
                    r--;
            }
        }
        return target - closestsum;
        
    }
}