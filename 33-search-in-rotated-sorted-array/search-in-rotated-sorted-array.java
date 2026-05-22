class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0]  == target)
                return 0;
            return -1;
        }
        
        int pivot = findPivot(nums);
        

        int idx = bs(0 , pivot - 1 , nums , target);

        if(idx != -1)
            return idx;
        
        idx = bs(pivot , nums.length - 1 , nums , target);

        return idx;

    }

    private  int findPivot(int[] nums){
        int l = 0 , r = nums.length - 1;
        int mid;
        while(l < r){
            mid = l + (r - l)/2;
            if(nums[mid] > nums[r])
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    private int bs(int l , int r , int[] nums , int target){
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}