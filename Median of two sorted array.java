class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
int len2 = nums2.length;
int len3 = len1 + len2;
int sum;
double result;
int[] arr = new int[len3];

    for(int i = 0; i < len1; i++){
        arr[i] = nums1[i];
    }
    for(int i = 0; i < len2; i++){
        arr[len1 + i] = nums2[i];
    }
    Arrays.sort(arr);
    
    if(len3%2 == 0){
        sum = arr[len3/2 - 1] + arr[len3/2];
        result = (double)sum/2;
        return result;
    }
    else
    {
        result = arr[len3/2];
        return result;
    }
}
    }
