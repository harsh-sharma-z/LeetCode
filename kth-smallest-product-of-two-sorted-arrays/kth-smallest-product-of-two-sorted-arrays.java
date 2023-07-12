class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long si = -10000000000l;
        long ei = 10000000000l;
        long ans=0;

        while(si <= ei) {
            long mid = (si + ei) / 2;
            if(countOfProduct(nums1, nums2, mid) >= k) {
                ans = mid;
                ei = mid - 1;
            }
            else {
                si = mid + 1;
            }
        }

        return ans;
    }

    private long countOfProduct(int[] arr1, int[] arr2, long k){
        long ans=0;
        for(int e1 : arr1){
            if(e1 >= 1){
                int lo = 0;
                int hi = arr2.length-1;
                long c = 0;
                while(lo <= hi){
                    int mid = (lo + hi)/2;
                    if((long)(e1) * arr2[mid] <= k){
                        c = mid+1;
                        lo = mid+1;
                    }
                    else{
                        hi = mid-1;
                    }
                }
                ans+=c;
            }
            else{
                int lo = 0;
                int hi = arr2.length-1;
                long c = 0;
                while(lo <= hi){
                    int mid = (lo + hi)/2;
                    if((long)(e1) * arr2[mid] <= k){
                        c = arr2.length - mid;
                        hi = mid-1;
                    }
                    else{
                        lo = mid+1;
                    }
                }
                ans += c;
            }
        }
        return ans;
    }
}

