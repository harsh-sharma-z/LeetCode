class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums , nums.length , target);
        int last = findLast(nums , nums.length , target);

        int[] ans = {first , last};

        return ans;
    }

    private int findFirst(int[] arr , int n , int x){
        int low = 0 , high = n - 1;
        int first = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == x){
                first = mid;
                high = mid - 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return first;
    }

    private int findLast(int[] arr , int n , int x){
        int low = 0 , high = n - 1;
        int last = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] == x){
                last = mid;
                low = mid + 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return last;
    }
}