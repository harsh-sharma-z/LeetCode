class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int m = n-1;
        int[] pairSum = new int [m];
        for(int i = 0 ; i < m ; i++)
            pairSum[i] = weights[i] + weights[i+1]; // breakpoints bana liye
        Arrays.sort(pairSum); 
        long maxSum = 0 , minSum = 0;

        for(int i = 0 ; i < k-1 ; i++){ //pairs uthao 
            minSum += pairSum[i]; //min elements ka sum
            maxSum += pairSum[m-1-i]; //max elements ka sum
        }
        return maxSum - minSum;
    }
}