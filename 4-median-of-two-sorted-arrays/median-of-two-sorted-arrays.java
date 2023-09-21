class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int size = n + m;
        int[] temp = new int[size];
        int i = 0 , j = 0 , t = 0 ;
        while(i < n && j < m){
            if(nums1[i] <= nums2[j])
                temp[t] = nums1[i++];
            else
                temp[t] = nums2[j++];
            t++;
        }
        while(i < n)
            temp[t++] = nums1[i++];
        while(j < m)
            temp[t++] = nums2[j++];

        if(size % 2 != 0)
            return (double)temp[size / 2];
        return (temp[(size / 2) - 1] + temp[size / 2]) / 2.0;
    }
}