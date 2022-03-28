class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[]=new int[m];
        for(int t=0;t<m;t++){
            arr[t]=nums1[t];
        }
        int i=0,j=0,k=0;
        while(i<m&&j<n){
            if(arr[i]<=nums2[j]){
                nums1[k++]=arr[i++];
            }
            else{
                 nums1[k++]=nums2[j++];
            }
        }
        while(i<m){
            nums1[k++]=arr[i++];
        }
        while(j<n){
            nums1[k++]=nums2[j++];
        }
        
    }
}
