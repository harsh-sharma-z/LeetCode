class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int pivot = findPivot(nums);

        if(bs(0 , pivot - 1 , nums , target))
            return true;
        return bs(pivot , n - 1 , nums , target);
    }
    private boolean bs(int l , int r , int[] nums , int target){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
    private int findPivot(int[] nums){
        int l = 0 , r = nums.length - 1;
        int mid;
        while(l < r){
            while(l < r && nums[l] == nums[l + 1])
                l++;
            while(l < r && nums[r] == nums[r - 1])
                r--;
            mid = l + (r - l)/2;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
}