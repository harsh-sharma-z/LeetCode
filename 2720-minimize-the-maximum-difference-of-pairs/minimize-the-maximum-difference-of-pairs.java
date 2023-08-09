class Solution {
    private int n;
    public int minimizeMax(int[] nums, int p) {
        n = nums.length;
        Arrays.sort(nums);
        int l = 0 , r = nums[n - 1] - nums[0]; //max possible difference
        int res = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r - l)/2;
            if(isValid(nums , mid , p)){
                res = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return res;
    }

    private boolean isValid(int[] nums , int mid , int p){
        int i = 0;
        int c = 0;
        while(i < n - 1){
            if((nums[i + 1] - nums[i]) <= mid){
                c++;
                i += 2;
            }
            else{
                i++;
            }
        }
        return c >= p;
    }
}