class Solution {
    public int search(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;
        int mid;
        while(lo<=hi)
        {
            mid=lo+(hi-lo)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                hi=mid-1;
            if(nums[mid]<target)
                lo=mid+1;
        }
        return -1;
    }
}