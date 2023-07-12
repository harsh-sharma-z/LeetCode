class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return help(nums1 , nums2);
        return help(nums2 , nums1);
    }
    private double help(int[] arr1 , int[] arr2){
        int lo = 0 , hi = arr1.length , n = arr1.length , m = arr2.length;
        while(lo <= hi){
            int cut1 = (lo + hi) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;
            int l1 = cut1==0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int r1 = cut1==n ? Integer.MAX_VALUE : arr1[cut1];
            int l2 = cut2==0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r2 = cut2==m ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((n + m) % 2 == 0){
                    return (Math.max(l1, l2) + Math.min(r1 , r2)) / 2.0;
                }
                else{
                    return Math.max(l1 , l2);
                }
            }
            else if(l1 > r2){
                hi = cut1 - 1;
            }
            else{
                lo = cut1 + 1;
            }
        }
        return 0;
    }
}