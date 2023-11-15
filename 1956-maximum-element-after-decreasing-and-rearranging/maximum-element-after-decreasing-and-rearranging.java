class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int max = -1;

        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                arr[0] = 1;
            }else if(Math.abs(arr[i] - arr[i - 1]) > 1){
                arr[i] = arr[i - 1] + 1;
            }

            max = Math.max(max , arr[i]);
        }
        return max;
    }
}