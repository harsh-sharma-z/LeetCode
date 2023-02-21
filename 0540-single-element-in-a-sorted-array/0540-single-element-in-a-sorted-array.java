class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
            return nums[0];
        else if(nums[0]!=nums[1])
            return nums[0];
        else if(nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        int low=0,high=nums.length-1,mid;
        while(low<=high)
        {
            mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
                return nums[mid];
            
            if(((mid%2)==0 && nums[mid]==nums[mid+1]) || ((mid%2)==1 && nums[mid]==nums[mid-1]))
                low=mid+1;
            else
                high=mid-1;
        }
        return 0;
    }
}